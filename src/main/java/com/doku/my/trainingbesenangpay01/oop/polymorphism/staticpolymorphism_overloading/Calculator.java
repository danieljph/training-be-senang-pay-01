package com.doku.my.trainingbesenangpay01.oop.polymorphism.staticpolymorphism_overloading;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Calculator
{
    public int add(int operand1, int operand2)
    {
        return operand1 + operand2;
    }

    public double add(double operand1, double operand2)
    {
        return operand1 + operand2;
    }

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        System.out.println("Result (int)   : " + calculator.add(1, 2));
        System.out.println("Result (double): " + calculator.add(1.2, 3.4));
    }
}
