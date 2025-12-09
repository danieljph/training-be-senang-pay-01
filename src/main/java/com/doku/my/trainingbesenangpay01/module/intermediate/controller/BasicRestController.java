package com.doku.my.trainingbesenangpay01.module.intermediate.controller;

import com.doku.my.trainingbesenangpay01.module.intermediate.dto.BasicGetResponse;
import com.doku.my.trainingbesenangpay01.module.intermediate.dto.BasicPostRequest;
import com.doku.my.trainingbesenangpay01.module.intermediate.dto.BasicPostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("UastIncorrectHttpHeaderInspection")
@RequestMapping("/basic-rest")
@RestController
public class BasicRestController
{
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    (
        path = "/basic-get/{pathVar1}/api-test",
        produces =
        {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        }
    )
    public BasicGetResponse basicGet
    (
        @RequestHeader("x-header-1") String header1,
        @PathVariable String pathVar1,
        @RequestParam String urlParam1
    )
    {
        return BasicGetResponse.builder()
            .header1(header1)
            .pathVar1(pathVar1)
            .urlParam1(urlParam1)
            .build();
    }

    @PostMapping("/basic-post")
    public ResponseEntity<BasicPostResponse> basicPost(@Validated @RequestBody BasicPostRequest request)
    {
        var response = BasicPostResponse.builder()
            .message("Hi from server!")
            .field1(request.getField1())
            .field2(request.getField2())
            .field3(request.getField3())
            .amount(BasicPostResponse.Amount.builder()
                .value(request.getAmount().getValue())
                .currency(request.getAmount().getCurrency())
                .build()
            )
            .build();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
