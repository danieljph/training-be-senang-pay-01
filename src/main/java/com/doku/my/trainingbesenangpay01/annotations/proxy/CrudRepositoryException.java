package com.doku.my.trainingbesenangpay01.annotations.proxy;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class CrudRepositoryException extends RuntimeException
{
    public CrudRepositoryException()
    {
    }

    public CrudRepositoryException(String message)
    {
        super(message);
    }
}
