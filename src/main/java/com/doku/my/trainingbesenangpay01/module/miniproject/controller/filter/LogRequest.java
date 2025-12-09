package com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LogRequest
{
    boolean value() default true;
}
