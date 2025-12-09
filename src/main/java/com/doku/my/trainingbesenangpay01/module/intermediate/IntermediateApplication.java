package com.doku.my.trainingbesenangpay01.module.intermediate;

import com.doku.my.trainingbesenangpay01.module.intermediate.servlet.CustomNativeServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@PropertySource("classpath:application-intermediate.properties")
@SpringBootApplication
public class IntermediateApplication
{
    @Bean
    public ServletRegistrationBean<CustomNativeServlet> servletRegistrationBean()
    {
        return new ServletRegistrationBean<>(new CustomNativeServlet(), "/native-servlet/*");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(IntermediateApplication.class, args);
    }
}
