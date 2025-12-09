package com.doku.my.trainingbesenangpay01.oop.abstraction.shape;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Circle implements Shape
{
    private final double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
}
