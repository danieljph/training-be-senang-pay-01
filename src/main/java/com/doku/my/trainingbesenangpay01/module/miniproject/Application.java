package com.doku.my.trainingbesenangpay01.module.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@PropertySource("classpath:application-mini-project.properties")
@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
