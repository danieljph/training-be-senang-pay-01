package com.doku.my.trainingbesenangpay01.module.miniproject.controller.advice;

import com.doku.my.trainingbesenangpay01.module.miniproject.dto.SnapBaseResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.exception.AcquirerException;
import com.doku.my.trainingbesenangpay01.module.miniproject.util.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
@Order(0)
@ControllerAdvice
public class AcquirerControllerAdvice
{
    @ExceptionHandler(AcquirerException.class)
    public ResponseEntity<SnapBaseResponse> handleAcquirerException(AcquirerException ex)
    {
        log.error("Handle AcquirerException. Cause: {} - {}\n{}", ex.getClass().getSimpleName(), ex.getMessage(), AppUtils.toString(ex));
        return generateResponseEntity(ex.getSnapResponse());
    }

    @SuppressWarnings("SameParameterValue")
    private ResponseEntity<SnapBaseResponse> generateResponseEntity(SnapResponse snapResponse)
    {
        return ResponseEntity.status(snapResponse.getHttpStatus())
            .body(SnapBaseResponse.builder()
                .responseCode(snapResponse.buildResponseCode())
                .responseMessage(snapResponse.getResponseMessage())
                .build()
            );
    }
}
