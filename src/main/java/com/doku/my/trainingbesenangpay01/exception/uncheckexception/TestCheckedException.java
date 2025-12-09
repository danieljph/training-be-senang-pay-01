package com.doku.my.trainingbesenangpay01.exception.uncheckexception;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class TestCheckedException
{
    public void validateName(String name)
    {
        if(name.startsWith("John"))
        {
            throw new MyRuntimeException("Name must not start with 'John'.");
        }
    }

    public static void main(String[] args)
    {
        String name = "John Doe";

        TestCheckedException testCheckedException = new TestCheckedException();
        testCheckedException.validateName(name); // No need to catch the exception.
    }
}
