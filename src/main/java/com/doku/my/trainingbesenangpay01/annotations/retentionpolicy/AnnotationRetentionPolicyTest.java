package com.doku.my.trainingbesenangpay01.annotations.retentionpolicy;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@AnnotationRetentionPolicySource("will-only-be-read-by-annotation-preprocessor-when-compiling-file")
@AnnotationRetentionPolicyClass("will-included-in-class-file-but-not-available-at-runtime")
@AnnotationRetentionPolicyRuntime(value = "will-be-available-in-class-file-and-runtime", count = 42)
public class AnnotationRetentionPolicyTest
{
    public static void main(String[] args)
    {
        var a = new AnnotationRetentionPolicyTest();

        var source = a.getClass().getAnnotation(AnnotationRetentionPolicySource.class);
        System.out.println("Source : " + source);

        var clazz = a.getClass().getAnnotation(AnnotationRetentionPolicyClass.class);
        System.out.println("Class  : " + clazz);

        var runtime = a.getClass().getAnnotation(AnnotationRetentionPolicyRuntime.class);
        System.out.println("Runtime: " + runtime);
    }
}
