package com.doku.my.trainingbesenangpay01.oop.encapsulation.package1;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class OtherPerson
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.field1 = "Field-1";
        person.field2 = "Field-2";
        //person.field3 = "Field-3"; // This field is private. Only Person class can access it.
        person.field4 = "Field-4";
        System.out.println(person);

        person.method1();
        person.method2();
        //person.method3(); // This method is private. Only Person class can access it.
        person.method4();
    }
}
