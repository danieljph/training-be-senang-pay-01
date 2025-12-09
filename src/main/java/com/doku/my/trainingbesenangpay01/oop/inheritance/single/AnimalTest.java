package com.doku.my.trainingbesenangpay01.oop.inheritance.single;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class AnimalTest
{
    public static void main(String[] args)
    {
        Animal animal1 = new Dog();
        animal1.eat();

        System.out.println("========================================");


        Dog animal2 = new GermanShepherd();
        animal2.eat();
        animal2.bark();

        System.out.println("========================================");

        GermanShepherd animal3 = new GermanShepherd();
        animal3.eat();
        animal3.bark();
        animal3.jumpHigh();
    }
}
