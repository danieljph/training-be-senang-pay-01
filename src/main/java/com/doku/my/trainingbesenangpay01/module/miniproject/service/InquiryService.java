package com.doku.my.trainingbesenangpay01.module.miniproject.service;

import com.doku.my.trainingbesenangpay01.module.miniproject.dto.Amount;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.InquiryRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.InquiryResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.AcquirerStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Inquiry;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.InquiryStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.RegisterStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.exception.AcquirerException;
import com.doku.my.trainingbesenangpay01.module.miniproject.model.Srw;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.AcquirerRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.InquiryRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class InquiryService
{
    private final AcquirerRepository acquirerRepository;
    private final RegisterRepository registerRepository;
    private final InquiryRepository inquiryRepository;

    @Transactional(rollbackFor = Exception.class)
    public Srw<InquiryResponse> inquiry(String xPartnerId, InquiryRequest request)
    {
        var acquirer = acquirerRepository.findFirstByClientIdAndStatus(xPartnerId, AcquirerStatus.ACTIVE)
            .orElseThrow(() -> new AcquirerException(SnapResponse.PARTNER_NOT_FOUND));

        var virtualAccountNo = request.getVirtualAccountNo();

        var register = registerRepository.findFirstByVirtualAccountNumberAndStatus(virtualAccountNo, RegisterStatus.ACTIVE)
            .orElseThrow(() -> new AcquirerException(SnapResponse.INVALID_BILL_OR_VIRTUAL_ACCOUNT));

        var inquiry = Inquiry.builder()
            .merchant(register.getMerchant())
            .acquirer(acquirer)
            .register(register)
            .acquirerRequestId(request.getAcquirerRequestId())
            .invoiceNumber(register.getInvoiceNumber())
            .virtualAccountNumber(register.getVirtualAccountNumber())
            .virtualAccountName(register.getVirtualAccountName())
            .virtualAccountEmail(register.getVirtualAccountEmail())
            .virtualAccountPhone(register.getVirtualAccountPhone())
            .amount(register.getAmount())
            .currency(register.getCurrency())
            .additionalInfo(request.getAdditionalInfo())
            .status(InquiryStatus.SUCCESS)
            .build();

        inquiryRepository.save(inquiry);

        var snapResponse = SnapResponse.SUCCESSFUL;

        return Srw.<InquiryResponse>builder()
            .httpStatus(snapResponse.getHttpStatus())
            .body(InquiryResponse.builder()
                .responseCode(snapResponse.buildResponseCode())
                .responseMessage(snapResponse.getResponseMessage())
                .virtualAccountData(InquiryResponse.VirtualAccountData.builder()
                    .acquirerRequestId(request.getAcquirerRequestId())
                    .virtualAccountNo(request.getVirtualAccountNo())
                    .virtualAccountName(register.getVirtualAccountName())
                    .virtualAccountEmail(register.getVirtualAccountEmail())
                    .virtualAccountPhone(register.getVirtualAccountPhone())
                    .amount(Amount.builder()
                        .value(register.getAmount().toString())
                        .currency(register.getCurrency())
                        .build()
                    )
                    .additionalInfo(request.getAdditionalInfo())
                    .build()
                )
                .build()
            )
            .build();
    }
}
