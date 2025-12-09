package com.doku.my.trainingbesenangpay01.syntax.basic;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BasicSyntax
{
    public static void main(String[] args)
    {
        // Single line comment.

        /*
         * Multi line comment.
         */

        var a = 1;
        int b = 2;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("========================================");

        for(int i=0; i<3; i++)
        {
            System.out.println("for-loop: " + i);
        }

        System.out.println("========================================");

        int counter = 0;
        int maxLoop = 3;

        do
        {
            System.out.printf("do-while-loop: %d%n", counter++);
        }
        while(counter < maxLoop);

        System.out.println("========================================");

        counter = 0;

        while(counter < maxLoop)
        {
            System.out.printf("while-loop: %d%n", counter++);
        }

        System.out.println("========================================");
        int input = 42;
        testPrintInput(++input);
        System.out.println("After testPrintInput: " + input);
        System.out.println("========================================");
        testPrintInput(input++);
        System.out.println("After testPrintInput: " + input);
        System.out.println("========================================");

        boolean isValid = true;

        if(isValid)
        {
            System.out.println("VALID");
        }
        else
        {
            System.out.println("INVALID");
        }

        System.out.println("========================================");

        int number = 2;
        String evenOrOdd = (input % 2 == 0) ? "Even" : "Odd";
        System.out.printf("%s is %s number.%n", number, evenOrOdd);

        var month = "January";

        System.out.println("========================================");

        switch(month)
        {
            case "January":
                System.out.println("31 days");
                break;
            case "February":
                System.out.println("28/29 days");
                break;
            case "March":
                System.out.println("31 days");
                break;
            case "April":
                System.out.println("30 days");
                break;
            default:
                System.out.println("Invalid month.");
        }
    }

    public static void testPrintInput(int input)
    {
        System.out.println("testInput: " + input);
    }
}
