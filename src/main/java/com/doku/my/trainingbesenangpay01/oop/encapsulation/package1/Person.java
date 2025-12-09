package com.doku.my.trainingbesenangpay01.oop.encapsulation.package1;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Person
{
    public String field1;
    protected String field2;
    private String field3;
    String field4;

    public void method1()
    {
        System.out.println("method1");
    }

    protected void method2()
    {
        System.out.println("method2");
    }

    private void method3()
    {
        System.out.println("method3");
    }

    void method4()
    {
        System.out.println("method4");
    }

    @Override
    public String toString()
    {
        return "Person{" +
            "field1='" + field1 + '\'' +
            ", field2='" + field2 + '\'' +
            ", field3='" + field3 + '\'' +
            ", field4='" + field4 + '\'' +
            '}';
    }

    public static void main(String[] args)
    {
        Person person = new Person();
        person.field1 = "Field-1";
        person.field2 = "Field-2";
        person.field3 = "Field-3";
        person.field4 = "Field-4";
        System.out.println(person);

        person.method1();
        person.method2();
        person.method3();
        person.method4();
    }
}
