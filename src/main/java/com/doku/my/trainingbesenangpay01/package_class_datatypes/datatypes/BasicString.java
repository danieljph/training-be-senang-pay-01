package com.doku.my.trainingbesenangpay01.package_class_datatypes.datatypes;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BasicString
{
    public static void main(String[] args)
    {
        // String is not a primitive type.
        String name = "John Doe";

        System.out.println("Input                         : " + name);
        System.out.println("Is John Doe                   : " + isJohnDoe(name));
        System.out.println("Is John Doe using EQ Operator : " + isJohnDoeUsingEqualOperator(name));

        System.out.println("========================================");

        name = "John Doe Remove_This";
        name = name.substring(0, name.indexOf(" Remove_This"));

        System.out.println("Input                         : " + name);
        System.out.println("Is John Doe after remove      : " + isJohnDoe(name));
        System.out.println("Is John Doe using EQ Operator : " + isJohnDoeUsingEqualOperator(name));

        System.out.println("========================================");

        String multiline = """
            {
                 "invoiceNumber": "INV_1765278959189",
                 "virtualAccountNo": "1765278959",
                 "virtualAccountName": "C_1765278959",
                 "virtualAccountEmail": "test.merchant.1765278959@test.com",
                 "virtualAccountPhone": "6281765278959",
                 "amount": {
                     "value": "12500.00",
                     "currency": "IDR"
                 },
                 "additionalInfo": {
                     "info1FromMerchantCreateVa": "Info 1 from Merchant Create VA"
                 }
             }
            """;
        System.out.println(multiline);
    }

    public static boolean isJohnDoe(String input)
    {
        return input.equals("John Doe");
    }

    public static boolean isJohnDoeUsingEqualOperator(String input)
    {
        return input == "John Doe"; // Do not use == for Strings.
    }
}
