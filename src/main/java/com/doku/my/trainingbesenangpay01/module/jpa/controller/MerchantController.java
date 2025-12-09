package com.doku.my.trainingbesenangpay01.module.jpa.controller;

import com.doku.my.trainingbesenangpay01.module.jpa.dto.FindByIdResponse;
import com.doku.my.trainingbesenangpay01.module.jpa.dto.InsertMerchantRequest;
import com.doku.my.trainingbesenangpay01.module.jpa.dto.InsertMerchantResponse;
import com.doku.my.trainingbesenangpay01.module.jpa.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@RequestMapping("/jpa/merchant")
@RestController
public class MerchantController
{
    private final MerchantService merchantService;

    @PostMapping("/insert-using-native-jpa")
    public ResponseEntity<InsertMerchantResponse> insertUsingNativeJpa(@Validated @RequestBody InsertMerchantRequest request)
    {
        var response = merchantService.insertUsingNativeJpa(request);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/insert-using-spring-data")
    public ResponseEntity<InsertMerchantResponse> insertUsingSpringData(@Validated @RequestBody InsertMerchantRequest request)
    {
        var response = merchantService.insertUsingSpringData(request);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<FindByIdResponse> findById(@PathVariable Long id, @RequestParam(required = false) boolean useSpringData)
    {
        var response = merchantService.findById(id, useSpringData);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
