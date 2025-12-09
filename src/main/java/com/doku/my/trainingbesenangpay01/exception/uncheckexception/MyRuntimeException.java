package com.doku.my.trainingbesenangpay01.exception.uncheckexception;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class MyRuntimeException extends RuntimeException
{
    public MyRuntimeException(String message)
    {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
