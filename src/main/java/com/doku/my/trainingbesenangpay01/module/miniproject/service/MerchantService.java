package com.doku.my.trainingbesenangpay01.module.miniproject.service;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Merchant;
import com.doku.my.trainingbesenangpay01.module.miniproject.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class MerchantService
{
    private final MerchantRepository merchantRepository;

    @Transactional(rollbackFor = Exception.class)
    public void insert(Merchant merchant)
    {
        merchantRepository.save(merchant);
    }
}
