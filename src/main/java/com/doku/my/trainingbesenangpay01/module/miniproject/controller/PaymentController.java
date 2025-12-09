package com.doku.my.trainingbesenangpay01.module.miniproject.controller;

import com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter.LogRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.PaymentRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.PaymentResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController
{
    private final PaymentService paymentService;

    @LogRequest
    @SuppressWarnings("UastIncorrectHttpHeaderInspection")
    @PostMapping(value = "/transfer-va/payment")
    public ResponseEntity<PaymentResponse> payment
    (
        @RequestHeader("X-PARTNER-ID") String xPartnerId,
        @Validated @RequestBody PaymentRequest request
    )
    {
        var srw = paymentService.payment(xPartnerId, request);

        return ResponseEntity
            .status(srw.getHttpStatus())
            .headers(srw.getHttpHeaders())
            .body(srw.getBody());
    }
}
