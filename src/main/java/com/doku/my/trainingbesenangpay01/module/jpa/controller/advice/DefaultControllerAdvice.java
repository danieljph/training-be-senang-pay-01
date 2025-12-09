package com.doku.my.trainingbesenangpay01.module.jpa.controller.advice;

import com.doku.my.trainingbesenangpay01.module.jpa.dto.BaseResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.util.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("DuplicatedCode")
@Slf4j
@Order(1)
@ControllerAdvice
public class DefaultControllerAdvice
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleException(Exception ex)
    {
        log.error("Handle Exception. Cause: {} - {}\n{}", ex.getClass().getSimpleName(), ex.getMessage(), AppUtils.toString(ex));
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.builder()
                .responseMessage(ex.getMessage())
                .build()
            );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        var fieldErrors = ex.getBindingResult().getFieldErrors();
        var globalErrors = ex.getBindingResult().getGlobalErrors();
        var errorMessage = ex.getMessage();

        if(!fieldErrors.isEmpty())
        {
            errorMessage = fieldErrors
                .stream()
                .sorted(Comparator.comparing(FieldError::getField))
                .map(it -> String.format("%s: '%s'", it.getField(), it.getDefaultMessage()))
                .collect(Collectors.joining(" AND ")) + ".";
        }
        else if(!globalErrors.isEmpty())
        {
            errorMessage = globalErrors.getFirst().getDefaultMessage();
        }

        log.error("Handle MethodArgumentNotValidException. Cause: {}", errorMessage);

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse.builder()
                .responseMessage(errorMessage)
                .build()
            );
    }
}
