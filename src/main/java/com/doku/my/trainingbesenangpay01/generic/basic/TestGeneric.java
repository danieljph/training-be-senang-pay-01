package com.doku.my.trainingbesenangpay01.generic.basic;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class TestGeneric
{
    public static void main(String[] args)
    {
        var srw1 = new ServiceResponseWrapper<>(200, new Response1("VA_00001"));
        System.out.println(srw1.getBody().getVaNo());

        var srw2 = new ServiceResponseWrapper<>(200, new Response2("CN_0001"));
        System.out.println(srw2.getBody().getCardNo());

        var srw3 = new ServiceResponseWrapper<>(200, "Simple String Body");
        System.out.println(srw3.getBody());
    }
}
