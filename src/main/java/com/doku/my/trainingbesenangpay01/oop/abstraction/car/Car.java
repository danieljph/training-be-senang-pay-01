package com.doku.my.trainingbesenangpay01.oop.abstraction.car;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public abstract class Car
{
    public abstract void startEngine();

    public void run()
    {
        startEngine();
        System.out.printf("%s is running...%n", this.getClass().getSimpleName());
    }
}
