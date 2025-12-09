package com.doku.my.trainingbesenangpay01.oop.polymorphism.dynamicpolymorphism_overriding;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class AnimalTest
{
    public static void main(String[] args)
    {
        Dog animal1 = new Dog();
        animal1.sound();

        System.out.println("========================================");

        Cat animal2 = new Cat();
        animal2.sound();

        System.out.println("========================================");

        Animal animal3 = new Dog();
        animal3.sound();

        System.out.println("========================================");

        Animal animal4 = new Cat();
        animal4.sound();
    }
}
