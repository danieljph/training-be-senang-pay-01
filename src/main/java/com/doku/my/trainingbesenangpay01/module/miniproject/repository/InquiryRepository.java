package com.doku.my.trainingbesenangpay01.module.miniproject.repository;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Inquiry;
import com.doku.my.trainingbesenangpay01.module.miniproject.entity.InquiryStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface InquiryRepository extends CrudRepository<Inquiry, Long>
{
    Optional<Inquiry> findFirstByVirtualAccountNumberAndAcquirerRequestIdAndStatusIn(String virtualAccountNumber, String acquirerRequestId, List<InquiryStatus> statuses);
}
