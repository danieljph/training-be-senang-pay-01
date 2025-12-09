package com.doku.my.trainingbesenangpay01.annotations.proxy;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Table("person")
public interface PersonRepository
{
    void findByName(String name);
}
