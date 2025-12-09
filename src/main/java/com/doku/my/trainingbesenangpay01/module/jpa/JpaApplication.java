package com.doku.my.trainingbesenangpay01.module.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@PropertySource("classpath:application-jpa.properties")
@SpringBootApplication
public class JpaApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JpaApplication.class, args);
    }
}
