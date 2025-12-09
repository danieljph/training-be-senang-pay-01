package com.doku.my.trainingbesenangpay01.package_class_datatypes.clazz;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class SimpleClass
{
    byte b1;
    short s1;
    int i1;
    long l1;

    float f1;
    double d1;

    boolean isJavaFun1;
    char grade1;

    Byte b2;
    Short s2;
    Integer i2;
    Long l2;

    Float f2;
    Double d2;

    Boolean isJavaFun2;
    Character grade2;

    // Array. Java Virtual Machine Specification (JVMS) limits the number of dimensions to 255
    int[] array1D = new int[10];
    long[][] array2D = {
        {1, 2},
        {3, 4}
    };
    float[][][] array3D = new float[2][3][4];
    double[][][][] array4D = new double[2][3][4][5];

    public static void main(String[] args)
    {
        SimpleClass sc = new SimpleClass();

        System.out.println("b1: " + sc.b1);
        System.out.println("s1: " + sc.s1);
        System.out.println("i1: " + sc.i1);
        System.out.println("l1: " + sc.l1);
        System.out.println("f1: " + sc.f1);
        System.out.println("d1: " + sc.d1);
        System.out.println("isJavaFun1: " + sc.isJavaFun1);
        System.out.println("grade1: " + sc.grade1);

        System.out.println("========================================");

        System.out.println("b2: " + sc.b2);
        System.out.println("s2: " + sc.s2);
        System.out.println("i2: " + sc.i2);
        System.out.println("l2: " + sc.l2);
        System.out.println("f2: " + sc.f2);
        System.out.println("d2: " + sc.d2);
        System.out.println("isJavaFun2: " + sc.isJavaFun2);
        System.out.println("grade2: " + sc.grade2);
    }
}
