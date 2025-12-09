package com.doku.my.trainingbesenangpay01.module.jpa.service;

import com.doku.my.trainingbesenangpay01.module.jpa.dto.FindByIdResponse;
import com.doku.my.trainingbesenangpay01.module.jpa.dto.InsertMerchantRequest;
import com.doku.my.trainingbesenangpay01.module.jpa.dto.InsertMerchantResponse;
import com.doku.my.trainingbesenangpay01.module.jpa.entity.Merchant;
import com.doku.my.trainingbesenangpay01.module.jpa.entity.MerchantStatus;
import com.doku.my.trainingbesenangpay01.module.jpa.repository.MerchantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class MerchantService
{
    private final MerchantRepository merchantRepository;

    @PersistenceContext private EntityManager entityManager;

    @Transactional
    public InsertMerchantResponse insertUsingNativeJpa(InsertMerchantRequest request)
    {
        var merchant = Merchant.builder()
            .name(request.getName())
            .clientId(request.getClientId())
            .clientSecret(request.getClientSecret())
            .status(MerchantStatus.ACTIVE)
            .build();

        entityManager.persist(merchant);

        return InsertMerchantResponse.builder()
            .id(merchant.getId())
            .name(merchant.getName())
            .clientId(merchant.getClientId())
            .clientSecret(merchant.getClientSecret())
            .status(merchant.getStatus())
            .createdDate(merchant.getCreatedDate())
            .build();
    }

    @Transactional
    public InsertMerchantResponse insertUsingSpringData(InsertMerchantRequest request)
    {
        var merchant = Merchant.builder()
            .name(request.getName())
            .clientId(request.getClientId())
            .clientSecret(request.getClientSecret())
            .status(MerchantStatus.ACTIVE)
            .build();

        merchantRepository.save(merchant);

        return InsertMerchantResponse.builder()
            .id(merchant.getId())
            .name(merchant.getName())
            .clientId(merchant.getClientId())
            .clientSecret(merchant.getClientSecret())
            .status(merchant.getStatus())
            .createdDate(merchant.getCreatedDate())
            .build();
    }

    public FindByIdResponse findById(Long id, boolean useSpringData)
    {
        Optional<Merchant> merchantOpt;

        if(useSpringData)
        {
            merchantOpt = merchantRepository.findById(id);
        }
        else
        {
            var query = entityManager.createQuery("SELECT m FROM Merchant m WHERE m.id = :id", Merchant.class);
            query.setParameter("id", id);

            merchantOpt = query.getResultList()
                .stream()
                .findFirst();
        }

        var merchant = merchantOpt.orElseThrow(() -> new RuntimeException("Merchant not found"));

        return FindByIdResponse.builder()
            .id(merchant.getId())
            .name(merchant.getName())
            .clientId(merchant.getClientId())
            .clientSecret(merchant.getClientSecret())
            .status(merchant.getStatus())
            .createdDate(merchant.getCreatedDate())
            .build();
    }
}
