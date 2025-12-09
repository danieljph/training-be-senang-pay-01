package com.doku.my.trainingbesenangpay01.package_class_datatypes.clazz;

/**
 * Every Java class, either directly or indirectly, is a subclass of the java.lang.Object class.
 *
 * @author Daniel Joi Partogi Hutapea
 */
public class ComplexClass extends java.lang.Object
{
    private final int id;
    private String name;

    public ComplexClass(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public ComplexClass(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ComplexClass{" +
            "id=" + getId() +
            ", name='" + getName() + '\'' +
            '}';
    }

    public static void main(String[] args)
    {
        ComplexClass cc1 = new ComplexClass(1, "John Doe");
        System.out.println(cc1);

        cc1.setName("Jane Doe");
        System.out.println(cc1);

        ComplexClass cc2 = new ComplexClass(1);
        System.out.println(cc2);
    }
}
