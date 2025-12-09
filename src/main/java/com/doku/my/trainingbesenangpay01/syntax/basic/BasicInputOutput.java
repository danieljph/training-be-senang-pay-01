package com.doku.my.trainingbesenangpay01.syntax.basic;

import java.util.Scanner;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BasicInputOutput
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");

        String name = scanner.nextLine();
        System.out.println("[STD_STREAM] Hello " + name);
        System.err.println("[ERR_STREAM] Hi " + name);

        // Execute: mvn clean compile
        // Open /target/classes on terminal
        // Execute: java com.doku.my.trainingbesenangpay01.syntax.basic.BasicInputOutput 2> error.txt
    }
}
