package com.doku.my.trainingbesenangpay01.annotations.beanvalidation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Person
{
    @Length(min = 1, max = 5) private String name;
    @Length(min = 1, max = 10) private String address;
}
