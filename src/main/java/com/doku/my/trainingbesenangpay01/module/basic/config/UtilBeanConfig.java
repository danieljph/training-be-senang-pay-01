package com.doku.my.trainingbesenangpay01.module.basic.config;

import com.doku.my.trainingbesenangpay01.module.basic.support.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Configuration
public class UtilBeanConfig
{
    @Bean
    public Calculator calculator()
    {
        return new Calculator("Casio");
    }
}
