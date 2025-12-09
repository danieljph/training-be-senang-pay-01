package com.doku.my.trainingbesenangpay01.exception.checkexception;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class TestCheckedException
{
    public void validateName(String name) throws MyException
    {
        if(name.startsWith("John"))
        {
            throw new MyException("Name must not start with 'John'.");
        }
    }

    public static void main(String[] args)
    {
        String name = "John Doe";

        TestCheckedException testCheckedException = new TestCheckedException();

        try
        {
            testCheckedException.validateName(name); // MyException must be caught (using catch). If not, the code won't compile.
        }
        catch(MyException ex)
        {
            System.out.println("This name has been taken. Please choose another one.");
            System.err.println("Exception caught: " + ex.getMessage());
        }
    }
}
