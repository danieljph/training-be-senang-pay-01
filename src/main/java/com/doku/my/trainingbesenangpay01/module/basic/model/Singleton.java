package com.doku.my.trainingbesenangpay01.module.basic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class Singleton
{
    private String value;
}
