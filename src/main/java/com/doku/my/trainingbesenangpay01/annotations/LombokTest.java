package com.doku.my.trainingbesenangpay01.annotations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class LombokTest
{
    private String name;

    public static void main(String[] args)
    {
        LombokTest lt = LombokTest.builder()
            .name("John Doe")
            .build();

        System.out.println(lt);
    }
}
