package com.doku.my.trainingbesenangpay01.module.basic.support;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Calculator
{
    public String vendor;

    public Calculator(String vendor)
    {
        this.vendor = vendor;
    }

    public void sumAndPrint(int a, int b)
    {
        System.out.printf("[%s] Sum: %s%n", vendor, a + b);
    }
}
