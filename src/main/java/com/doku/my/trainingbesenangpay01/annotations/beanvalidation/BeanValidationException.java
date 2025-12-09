package com.doku.my.trainingbesenangpay01.annotations.beanvalidation;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BeanValidationException extends RuntimeException
{
    public BeanValidationException()
    {
    }

    public BeanValidationException(String message)
    {
        super(message);
    }
}
