package com.doku.my.trainingbesenangpay01.annotations.beanvalidation;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BeanValidatorTest
{
    public static void main(String[] args)
    {
        var person1 = Person.builder()
            .name("")
            .address("123 St")
            .build();

        var beanValidator = new BeanValidator();
        beanValidator.validate(person1);
        System.out.println("This line will be printed if person1 is valid.");

        var person2 = new Person();
        person2.setName("John");
        person2.setAddress("123 Main St 12345");
        beanValidator.validate(person2);
        System.out.println("This line will be printed if person2 is valid.");
    }
}
