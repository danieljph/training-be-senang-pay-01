package com.doku.my.trainingbesenangpay01.module.miniproject.service;

import com.doku.my.trainingbesenangpay01.module.miniproject.config.DistributedLockProperties;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.CreateVaRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.CreateVaResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.MerchantStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Register;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.RegisterStatus;
import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.exception.MerchantException;
import com.doku.my.trainingbesenangpay01.module.miniproject.model.Srw;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.MerchantRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.RegisterRepository;
import com.doku.my.trainingbesenangpay01.module.miniproject.support.DistributedLock;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class RegisterService
{
    private final DistributedLock distributedLock;
    private final DistributedLockProperties distributedLockProperties;

    private final MerchantRepository merchantRepository;
    private final RegisterRepository registerRepository;

    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Srw<CreateVaResponse> createVa(String xPartnerId, CreateVaRequest request)
    {
        var lockKey = request.getVirtualAccountNo();
        return distributedLock.executeLocked(
            lockKey,
            distributedLockProperties.getCreateVaWaitingTimeDuration(),
            () -> createVaInLock(xPartnerId, request)
        );
    }

    private Srw<CreateVaResponse> createVaInLock(String xPartnerId, CreateVaRequest request)
    {
        var merchant = merchantRepository.findFirstByClientIdAndStatus(xPartnerId, MerchantStatus.ACTIVE)
            .orElseThrow(() -> new MerchantException(SnapResponse.INVALID_MERCHANT));

        var registerExist = registerRepository.existsByVirtualAccountNumberAndStatus(request.getVirtualAccountNo(), RegisterStatus.ACTIVE);

        if(registerExist)
        {
            throw new MerchantException(SnapResponse.VA_NUMBER_IS_IN_USE);
        }

        var register = Register.builder()
            .merchant(merchant)
            .invoiceNumber(request.getInvoiceNumber())
            .virtualAccountNumber(request.getVirtualAccountNo())
            .virtualAccountName(request.getVirtualAccountName())
            .virtualAccountEmail(request.getVirtualAccountEmail())
            .virtualAccountPhone(request.getVirtualAccountPhone())
            .amount(new BigDecimal(request.getAmount().getValue()))
            .currency(request.getAmount().getCurrency())
            .additionalInfo(request.getAdditionalInfo())
            .status(RegisterStatus.ACTIVE)
            .build();

        registerRepository.save(register);

        var snapResponse = SnapResponse.SUCCESSFUL;

        return Srw.<CreateVaResponse>builder()
            .httpStatus(snapResponse.getHttpStatus())
            .body(CreateVaResponse.builder()
                .responseCode(snapResponse.buildResponseCode())
                .responseMessage(snapResponse.getResponseMessage())
                .virtualAccountData(CreateVaResponse.VirtualAccountData.builder()
                    .invoiceNumber(request.getInvoiceNumber())
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
