package com.doku.my.trainingbesenangpay01.module.jpa.repository;

import com.doku.my.trainingbesenangpay01.module.jpa.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("SqlNoDataSourceInspection")
public interface MerchantRepository extends CrudRepository<Merchant, Long>
{
    Optional<Merchant> findById(Long id);

    @Query("SELECT m FROM Merchant m WHERE m.clientId = ?1")
    Optional<Merchant> findByClientIdV1(String clientId);

    @Query("SELECT m FROM Merchant m WHERE m.clientId = :clientId")
    Optional<Merchant> findByClientIdV2(@Param("clientId") String clientId);

    @Query(value = "SELECT m FROM merchant m WHERE m.client_id = :clientId", nativeQuery = true)
    Optional<Merchant> findByClientIdV3(@Param("clientId") String clientId);
}
