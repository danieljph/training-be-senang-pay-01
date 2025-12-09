package com.doku.my.trainingbesenangpay01.oop.inheritance.multiple;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface Flyable
{
    default void fly()
    {
        System.out.println("Flying...");
    }

    default void move()
    {
        System.out.println("Moving using Flyable...");
    }
}
