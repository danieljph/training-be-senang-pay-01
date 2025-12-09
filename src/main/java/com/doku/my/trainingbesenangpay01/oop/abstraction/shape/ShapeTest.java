package com.doku.my.trainingbesenangpay01.oop.abstraction.shape;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class ShapeTest
{
    public static void main(String[] args)
    {
        Shape shape1 = new Circle(2);
        System.out.println("Area: " + shape1.getArea());

        Shape shape2 = new Rectangle(2, 3);
        System.out.println("Area: " + shape2.getArea());
    }
}
