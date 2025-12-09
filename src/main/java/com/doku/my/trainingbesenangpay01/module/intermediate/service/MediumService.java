package com.doku.my.trainingbesenangpay01.module.intermediate.service;

import com.doku.my.trainingbesenangpay01.module.intermediate.component.RequestScopeStorage;
import com.doku.my.trainingbesenangpay01.module.intermediate.component.SingletonStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class MediumService
{
    private final SingletonStorage singletonStorage;
    private final RequestScopeStorage requestScopeStorage;

    public void addToStorage(String id)
    {
        singletonStorage.increaseCounter();
        singletonStorage.getValues().add("Add-by-service-" + id);

        requestScopeStorage.increaseCounter();
        requestScopeStorage.getValues().add("Add-by-service-" + id);
    }
}
