package com.doku.my.trainingbesenangpay01.module.intermediate.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString
@Component
public class SingletonStorage
{
    private int counter;
    private List<String> values = new LinkedList<>();

    public void increaseCounter()
    {
        counter++;
    }
}
