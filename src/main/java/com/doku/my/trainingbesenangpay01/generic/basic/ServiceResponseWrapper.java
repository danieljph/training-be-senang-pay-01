package com.doku.my.trainingbesenangpay01.generic.basic;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class ServiceResponseWrapper<B>
{
    private int httpStatusCode;
    private B body;

    public ServiceResponseWrapper(int httpStatusCode, B body)
    {
        this.httpStatusCode = httpStatusCode;
        this.body = body;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode)
    {
        this.httpStatusCode = httpStatusCode;
    }

    public B getBody()
    {
        return body;
    }

    public void setBody(B body)
    {
        this.body = body;
    }
}
