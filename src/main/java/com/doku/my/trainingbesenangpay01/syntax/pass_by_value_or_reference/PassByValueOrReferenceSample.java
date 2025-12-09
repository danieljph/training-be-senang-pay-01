package com.doku.my.trainingbesenangpay01.syntax.pass_by_value_or_reference;

/**
 * Use https://dotnetfiddle.net/ to test C# online.
 *
 * Sample real Pass by Reference in C#:
 *
 * using System;
 *
 * public class Person
 * {
 *     public String name;
 *     public int age;
 *
 *     public Person(String name, int age)
 *     {
 *         this.name = name;
 *         this.age = age;
 *     }
 * }
 *
 * public class Program
 * {
 *     public static void swap(ref Person p1, ref Person p2)
 *     {
 *         Person p3 = p1;
 *         p1 = p2;
 *         p2 = p3;
 *     }
 *
 *     public static void generateNewObject(ref Person p1)
 *     {
 *         p1 = new Person("Generated", 30);
 *     }
 *
 *     public static void Main()
 *     {
 *         Person p1 = new Person("Daniel", 10);
 *         Person p2 = new Person("Joi", 20);
 *
 *         Console.WriteLine(": : : Before Swap : : :");
 *         Console.WriteLine("Person 1: {0} ({1} years old)", p1.name, p1.age);
 *         Console.WriteLine("Person 2: {0} ({1} years old)", p2.name, p2.age);
 *         Console.WriteLine();
 *
 *         swap(ref p1, ref p2);
 *
 *         Console.WriteLine(": : : After Swap : : :");
 *         Console.WriteLine("Person 1: {0} ({1} years old)", p1.name, p1.age);
 *         Console.WriteLine("Person 2: {0} ({1} years old)", p2.name, p2.age);
 *         Console.WriteLine();
 *
 *         generateNewObject(ref p1);
 *         Console.WriteLine(": : : After Generate New Object : : :");
 *         Console.WriteLine("Person 1: {0} ({1} years old)", p1.name, p1.age);
 *     }
 * }
 *
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings({"JavadocLinkAsPlainText", "JavadocBlankLines"})
public class PassByValueOrReferenceSample
{
    public static void increase(int number)
    {
        number++;
        System.out.println("[increase] " + number);
    }

    public static void addNamePrefix(Person person)
    {
        String temp = person.name;

        person = new Person();
        person.name = "Mr. " + temp;
        System.out.println("[addNamePrefix] " + person.name);
    }

    /**
     * This method will never work in Java.
     */
    public static void swap(Person p1, Person p2)
    {
        Person temp = p1;
        p1 = p2;
        p2 = temp;

        System.out.println("[swap] Person 1: " + p1.name);
        System.out.println("[swap] Person 2: " + p2.name);
    }

    public static void main(String[] args)
    {
        int number = 10;
        increase(number);
        System.out.println("[main] " + number);

        System.out.println("========================================");

        Person person1 = new Person();
        person1.name = "John";
        addNamePrefix(person1);
        System.out.println("[main] " + person1.name);

        System.out.println("========================================");

        Person p1 = new Person();
        p1.name = "John";

        Person p2 = new Person();
        p2.name = "Jane";

        swap(p1, p2);
        System.out.println("[main] Person 1: " + p1.name);
        System.out.println("[main] Person 2: " + p2.name);
    }
}
