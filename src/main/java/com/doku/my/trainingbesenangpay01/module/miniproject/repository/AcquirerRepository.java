package com.doku.my.trainingbesenangpay01.module.miniproject.repository;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Acquirer;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.AcquirerStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface AcquirerRepository extends CrudRepository<Acquirer, Long>
{
    Optional<Acquirer> findFirstByClientIdAndStatus(String clientId, AcquirerStatus status);
}
