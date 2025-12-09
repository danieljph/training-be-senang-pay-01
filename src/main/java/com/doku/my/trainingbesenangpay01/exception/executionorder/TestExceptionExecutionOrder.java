package com.doku.my.trainingbesenangpay01.exception.executionorder;

import com.doku.my.trainingbesenangpay01.exception.uncheckexception.MyRuntimeException;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class TestExceptionExecutionOrder
{
    public static int div(int operand1, int operand2) throws NumberFormatException, IndexOutOfBoundsException
    {
        int result;

        try
        {
            System.out.println("Before div.");
            result = operand1 / operand2;
            System.out.println("After div.");
        }
        catch(ArithmeticException ex)
        {
            System.out.println("At catch.");
            throw new MyRuntimeException("Cannot divide by zero.", ex);
        }
        finally
        {
            System.out.println("At finally.");
        }

        System.out.println("After try-catch-finally.");
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Result: " + div(10, 1));
        System.out.println("========================================");
        System.out.println("Result: " + div(10, 0));
    }
}
