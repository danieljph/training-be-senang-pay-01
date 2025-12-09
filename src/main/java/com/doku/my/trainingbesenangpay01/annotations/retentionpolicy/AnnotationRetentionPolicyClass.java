package com.doku.my.trainingbesenangpay01.annotations.retentionpolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface AnnotationRetentionPolicyClass
{
    String value() default "default";

    int count() default 0;
}
