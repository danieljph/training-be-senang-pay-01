package com.doku.my.trainingbesenangpay01.module.miniproject.service;

import com.doku.my.trainingbesenangpay01.module.miniproject.dto.PaymentRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.PaymentResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.AcquirerStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.InquiryStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Payment;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.PaymentStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.exception.AcquirerException;
import com.doku.my.trainingbesenangpay01.module.miniproject.model.Srw;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.AcquirerRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.InquiryRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class PaymentService
{
    private final AcquirerRepository acquirerRepository;
    private final InquiryRepository inquiryRepository;
    private final PaymentRepository paymentRepository;

    @Transactional(rollbackFor = Exception.class)
    public Srw<PaymentResponse> payment(String xPartnerId, PaymentRequest request)
    {
        var acquirer = acquirerRepository.findFirstByClientIdAndStatus(xPartnerId, AcquirerStatus.ACTIVE)
            .orElseThrow(() -> new AcquirerException(SnapResponse.PARTNER_NOT_FOUND));

        var virtualAccountNo = request.getVirtualAccountNo();

        var inquiry = inquiryRepository
            .findFirstByVirtualAccountNumberAndAcquirerRequestIdAndStatusIn
            (
                virtualAccountNo,
                request.getAcquirerRequestId(),
                List.of(InquiryStatus.SUCCESS, InquiryStatus.USED)
            )
            .orElseThrow(() -> new AcquirerException(SnapResponse.INVALID_BILL_OR_VIRTUAL_ACCOUNT));

        if(inquiry.getStatus() == InquiryStatus.USED)
        {
            throw new AcquirerException(SnapResponse.PAID_BILL);
        }

        var requestAmount = new BigDecimal(request.getAmount().getValue());

        if(inquiry.getAmount().compareTo(requestAmount) != 0)
        {
            throw new AcquirerException(SnapResponse.INVALID_AMOUNT);
        }

        var payment = Payment.builder()
            .merchant(inquiry.getMerchant())
            .acquirer(acquirer)
            .inquiry(inquiry)
            .acquirerRequestId(request.getAcquirerRequestId())
            .invoiceNumber(inquiry.getInvoiceNumber())
            .virtualAccountNumber(inquiry.getVirtualAccountNumber())
            .virtualAccountName(inquiry.getVirtualAccountName())
            .virtualAccountEmail(inquiry.getVirtualAccountEmail())
            .virtualAccountPhone(inquiry.getVirtualAccountPhone())
            .amount(inquiry.getAmount())
            .currency(inquiry.getCurrency())
            .additionalInfo(request.getAdditionalInfo())
            .status(PaymentStatus.SUCCESS)
            .build();

        paymentRepository.save(payment);

        inquiry.setStatus(InquiryStatus.USED);
        inquiryRepository.save(inquiry);

        var snapResponse = SnapResponse.SUCCESSFUL;

        return Srw.<PaymentResponse>builder()
            .httpStatus(snapResponse.getHttpStatus())
            .body(PaymentResponse.builder()
                .responseCode(snapResponse.buildResponseCode())
                .responseMessage(snapResponse.getResponseMessage())
                .virtualAccountData(PaymentResponse.VirtualAccountData.builder()
                    .acquirerRequestId(request.getAcquirerRequestId())
                    .virtualAccountNo(request.getVirtualAccountNo())
                    .virtualAccountName(request.getVirtualAccountName())
                    .virtualAccountEmail(request.getVirtualAccountEmail())
                    .virtualAccountPhone(request.getVirtualAccountPhone())
                    .amount(request.getAmount())
                    .additionalInfo(request.getAdditionalInfo())
                    .build()
                )
                .build()
            )
            .build();
    }
}
