package com.doku.my.trainingbesenangpay01.oop.encapsulation.package2;

import com.doku.my.trainingbesenangpay01.oop.encapsulation.package1.Person;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Employee extends Person
{
    public void printAllowedParentFields()
    {
        System.out.println("Field-1: " + field1);
        System.out.println("Field-2: " + field2);
        //System.out.println("Field-3: " + field3); // This field is private. Only Person class can access it.
        //System.out.println("Field-4: " + field4); // This field is default. Only classes in the same package can access it.
    }

    public static void main(String[] args)
    {
        Employee employee = new Employee();
        employee.field1 = "Field-1";
        employee.field2 = "Field-2";
        employee.printAllowedParentFields();
    }
}
