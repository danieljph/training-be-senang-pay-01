package com.doku.my.trainingbesenangpay01.module.miniproject.controller;

import com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter.LogRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.InquiryRequest;
import com.doku.my.trainingbesenangpay01.module.miniproject.dto.InquiryResponse;
import com.doku.my.trainingbesenangpay01.module.miniproject.service.InquiryService;
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
@RequestMapping("/inquiry")
public class InquiryController
{
    private final InquiryService inquiryService;

    @LogRequest
    @SuppressWarnings("UastIncorrectHttpHeaderInspection")
    @PostMapping(value = "/transfer-va/inquiry")
    public ResponseEntity<InquiryResponse> inquiry
    (
        @RequestHeader("X-PARTNER-ID") String xPartnerId,
        @Validated @RequestBody InquiryRequest request
    )
    {
        var srw = inquiryService.inquiry(xPartnerId, request);

        return ResponseEntity
            .status(srw.getHttpStatus())
            .headers(srw.getHttpHeaders())
            .body(srw.getBody());
    }
}
