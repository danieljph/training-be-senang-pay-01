package com.doku.my.trainingbesenangpay01.module.miniproject.repository;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Merchant;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.MerchantStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface MerchantRepository extends CrudRepository<Merchant, Long>
{
    Optional<Merchant> findFirstByClientIdAndStatus(String clientId, MerchantStatus status);
}
