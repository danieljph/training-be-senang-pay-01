package com.doku.my.trainingbesenangpay01.module.miniproject.repository;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Register;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.RegisterStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface RegisterRepository extends CrudRepository<Register, Long>
{
    Optional<Register> findFirstByVirtualAccountNumberAndStatus(String virtualAccountNumber, RegisterStatus status);

    boolean existsByVirtualAccountNumberAndStatus(String virtualAccountNumber, RegisterStatus status);
}
