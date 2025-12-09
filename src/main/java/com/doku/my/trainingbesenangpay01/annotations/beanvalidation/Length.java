package com.doku.my.trainingbesenangpay01.annotations.beanvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Length
{
    int max() default 0;
    int min() default 0;
}
