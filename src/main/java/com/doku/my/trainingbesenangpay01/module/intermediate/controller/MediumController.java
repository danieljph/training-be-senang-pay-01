package com.doku.my.trainingbesenangpay01.module.intermediate.controller;

import com.doku.my.trainingbesenangpay01.module.intermediate.component.RequestScopeStorage;
import com.doku.my.trainingbesenangpay01.module.intermediate.component.SingletonStorage;
import com.doku.my.trainingbesenangpay01.module.intermediate.dto.AddToStorageResponse;
import com.doku.my.trainingbesenangpay01.module.intermediate.service.MediumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@RequestMapping("/medium")
@RestController
public class MediumController
{
    private final SingletonStorage singletonStorage;
    private final RequestScopeStorage requestScopeStorage;

    private final MediumService mediumService;

    @GetMapping("/add-to-storage")
    public ResponseEntity<AddToStorageResponse> addToStorage(@RequestParam("id") String id)
    {
        singletonStorage.increaseCounter();
        singletonStorage.getValues().add("Add-by-controller-" + id);

        requestScopeStorage.increaseCounter();
        requestScopeStorage.getValues().add("Add-by-controller-" + id);

        mediumService.addToStorage(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(AddToStorageResponse.builder()
                .singletonStorage(AddToStorageResponse.Storage.builder()
                    .counter(singletonStorage.getCounter())
                    .values(singletonStorage.getValues())
                    .build()
                )
                .requestScopeStorage(AddToStorageResponse.Storage.builder()
                    .counter(requestScopeStorage.getCounter())
                    .values(requestScopeStorage.getValues())
                    .build()
                )
                .build()
            );
    }
}
