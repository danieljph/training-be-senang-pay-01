package com.doku.my.trainingbesenangpay01.package_class_datatypes.datatypes;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Random;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BasicDataTypes
{
    public static void primitiveType()
    {
        // Integer Types
        byte b = 1; // An 8-bit signed integer, ranging from -128 to 127.
        short s = 30_000; // A 16-bit signed integer, ranging from -32,768 to 32,767.
        int i = 1000000; // A 32-bit signed integer, ranging from -2,147,483,648 to 2,147,483,647. This is the most commonly used integer type.
        long l = 123456789012345L; // A 64-bit signed integer, ranging from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807. Used for very large whole numbers.

        // Floating Point Types
        float f = 3.14f; // A single-precision 32-bit IEEE 754 floating-point number. It offers about 6-7 decimal digits of precision. Values are suffixed with f (e.g., 3.14f).
        double d = 3.1415926535; // A double-precision 64-bit IEEE 754 floating-point number. It offers about 15-16 decimal digits of precision and is the default floating-point type in Java. Values are suffixed with d (e.g., 3.14159d) or no suffix.

        // Other Types:
        boolean isJavaFun = true; // Represents a logical value, which can only be true or false.
        char grade = 'A'; // A single 16-bit Unicode character. It can represent any character in the Unicode character set and is typically enclosed in single quotes (e.g., 'A'). It can also store integer values corresponding to Unicode code points.

        System.out.println("b: " + b);
        System.out.println("s: " + s);
        System.out.println("i: " + i);
        System.out.println("l: " + l);
        System.out.println("f: " + f);
        System.out.println("d: " + d);
        System.out.println("isJavaFun: " + isJavaFun);
        System.out.println("grade: " + grade);

        System.out.println("========================================");
        byte b1 = 0B0001; // Write a number in binary format.
        System.out.println("b1: " + b1);

        short s1 = 0xFF; // Write a number in hexadecimal format.
        System.out.println("s1: " + s1);

        int i1 = 010; // Write a number in octal format.
        System.out.println("i1: " + i1);
    }

    public static void wrapperType()
    {
        Byte b = 1; // Auto Boxing
        Short s = 30_000; // Auto Boxing
        Integer i = Integer.valueOf(1000000);
        Long l = Long.valueOf(123456789012345L);

        // Floating Point Types
        Float f = Float.valueOf(3.14f);
        Double d = Double.valueOf(3.1415926535);

        // Other Types:
        Boolean isJavaFun = Boolean.valueOf(true);
        Character grade = Character.valueOf('A');

        System.out.println("b: " + b);
        System.out.println("s: " + s);
        System.out.println("i: " + i);
        System.out.println("l: " + l);
        System.out.println("f: " + f);
        System.out.println("d: " + d);
        System.out.println("isJavaFun: " + isJavaFun);
        System.out.println("grade: " + grade);

        // Manual unboxing
        int iValue = i.intValue();
        System.out.println("iValue: " + iValue);

        // Auto unboxing
        long lValue = l;
        System.out.println("lValue: " + lValue);
    }

    /**
     * Always use BigInteger or BigDecimal for a more precision number.
     */
    public static void precisionIssueUsingFloatOrDouble()
    {
        double d = 0;

        for(int i=0; i<10; i++)
        {
            d += 0.1;
        }

        System.out.println("Value of d : "+ d); // Value of d : 0.9999999999999999
        System.out.println("Is d == 1  : "+ (d==1.0)); // Is d == 1  : false

        BigDecimal bd = BigDecimal.valueOf(0);

        for(int i=0; i<10; i++)
        {
            bd = bd.add(BigDecimal.valueOf(0.1));
        }

        System.out.println("Value of bd : "+ bd);
        System.out.println("Is bd == 1  : "+ (bd.compareTo(BigDecimal.ONE) == 0));
    }

    /**
     * The wrapper type is immutable. Every change will create a new object.
     */
    public static void increaseValue(Integer value)
    {
        value++;
        System.out.println("Value at increaseValue: "+ value);
    }

    /**
     * For Java 11 you need to add this line below to VM Options:
     * <br/>
     * --add-opens java.base/java.lang=ALL-UNNAMED
     */
    public static void hackWrapperTypeCache()
    {
        try
        {
            Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");
            Field field = clazz.getDeclaredField("cache");
            field.setAccessible(true);
            Integer[] cache = (Integer[]) field.get(clazz);

            // Rewrite the Integer cache
            for (int i = 0; i < cache.length; i++)
            {
                cache[i] = new Random().nextInt(cache.length);
            }

            // Prove randomness
            for (int i = 0; i < 10; i++)
            {
                System.out.println((Integer) i);
            }

            // The Program will print a random number due to the cache has been hacked.
        }
        catch(Exception ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public static void main(String[] args)
    {
        primitiveType();
        System.out.println("========================================");
        wrapperType();
        System.out.println("========================================");
        precisionIssueUsingFloatOrDouble();
        System.out.println("========================================");

        Integer value = 10;
        increaseValue(value);
        System.out.println("Value at main: "+ value);

        System.out.println("========================================");

        //hackWrapperTypeCache();
    }
}
