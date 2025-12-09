package com.doku.my.trainingbesenangpay01.module.intermediate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@PropertySource("classpath:application-intermediate.properties")
@SpringBootApplication
public class TomcatIntermediateApplication extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(TomcatIntermediateApplication.class, args);
    }
}
