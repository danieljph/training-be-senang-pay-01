package com.doku.my.trainingbesenangpay01.module.miniproject.controller.converter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Retention(RUNTIME)
@Target(PARAMETER)
public @interface SnapRequestHeader
{
}
