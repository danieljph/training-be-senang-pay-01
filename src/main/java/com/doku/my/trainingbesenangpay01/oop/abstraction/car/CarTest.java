package com.doku.my.trainingbesenangpay01.oop.abstraction.car;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class CarTest
{
    public static void main(String[] args)
    {
        Honda car1 = new Honda();
        car1.run();

        System.out.println("========================================");

        Toyota car2 = new Toyota();
        car2.run();

        System.out.println("========================================");

        Car car3 = new Honda();
        car3.run();

        System.out.println("========================================");

        Car car4 = new Toyota();
        car4.run();

        //Toyota car5 = (Toyota) car3;
        //car5.run();
    }
}
