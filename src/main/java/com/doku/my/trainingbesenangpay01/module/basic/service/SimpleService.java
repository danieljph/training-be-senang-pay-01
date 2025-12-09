package com.doku.my.trainingbesenangpay01.module.basic.service;

import com.doku.my.trainingbesenangpay01.module.basic.model.Prototype;
import com.doku.my.trainingbesenangpay01.module.basic.model.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Service
public class SimpleService
{
    @Autowired private Prototype prototype;
    @Autowired private Singleton singleton;

    public void setValue(String value)
    {
        prototype.setValue(value);
        singleton.setValue(value);
    }

    public void printValue()
    {
        System.out.println("Prototype.value: " + prototype.getValue());
        System.out.println("Singleton.value: " + singleton.getValue());
    }
}
