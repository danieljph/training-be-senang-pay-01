package com.doku.my.trainingbesenangpay01.package_class_datatypes.packages.test;

import com.doku.my.trainingbesenangpay01.package_class_datatypes.packages.package1.SamplePackage;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class TestPackage
{
    public static void main(String[] args)
    {
        SamplePackage samplePackage = new SamplePackage();
        samplePackage.sayHello();

        var samplePackage2 = new com.doku.my.trainingbesenangpay01.package_class_datatypes.packages.package2.SamplePackage();
        samplePackage2.sayHello();
    }
}
