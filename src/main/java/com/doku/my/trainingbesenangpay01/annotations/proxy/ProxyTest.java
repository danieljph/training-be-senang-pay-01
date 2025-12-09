package com.doku.my.trainingbesenangpay01.annotations.proxy;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class ProxyTest
{
    public static void main(String[] args)
    {
        var personRepository = CrudRepositoryHandler.createProxy(PersonRepository.class);
        personRepository.findByName("John");

        var merchantRepository = CrudRepositoryHandler.createProxy(MerchantRepository.class);
        merchantRepository.findByClient_IdAndStatus("BRN-123", "ACTIVE");
    }
}
