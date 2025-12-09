package com.doku.my.trainingbesenangpay01.module.basic;

import com.doku.my.trainingbesenangpay01.module.basic.model.Prototype;
import com.doku.my.trainingbesenangpay01.module.basic.model.Singleton;
import com.doku.my.trainingbesenangpay01.module.basic.service.SimpleService;
import com.doku.my.trainingbesenangpay01.module.basic.support.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@PropertySource("classpath:application-basic.properties")
@SpringBootApplication
(
    exclude =
    {
        WebMvcAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
    }
)
public class BasicApplication
{
    public static void main(String[] args)
    {
        var context = SpringApplication.run(BasicApplication.class, args);

        {
            var prototype1 = context.getBean(Prototype.class);
            prototype1.setValue("Prototype-1");
            System.out.println("Prototype.value: " + prototype1.getValue());

            var prototype2 = context.getBean(Prototype.class);
            System.out.println("Prototype.value: " + prototype2.getValue());
        }

        System.out.println("===========================================");

        {
            var singleton1 = context.getBean(Singleton.class);
            singleton1.setValue("Singleton-1");
            System.out.println("Singleton.value: " + singleton1.getValue());

            var singleton2 = context.getBean(Singleton.class);
            System.out.println("Singleton.value: " + singleton2.getValue());
        }

        System.out.println("===========================================");

        {
            var simpleService = context.getBean(SimpleService.class);
            simpleService.setValue("SimpleService-1");
            simpleService.printValue();
            System.out.println("===========================================");
            simpleService.printValue();
        }

        System.out.println("===========================================");

        {
            var calculator = context.getBean(Calculator.class);
            calculator.sumAndPrint(1, 2);
        }
    }
}
