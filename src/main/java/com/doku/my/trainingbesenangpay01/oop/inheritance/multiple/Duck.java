package com.doku.my.trainingbesenangpay01.oop.inheritance.multiple;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Duck implements Flyable, Swimmable
{
    @Override
    public void move()
    {
        Flyable.super.move();
    }
}
