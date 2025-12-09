package com.doku.my.trainingbesenangpay01.module.miniproject.controller;

import com.doku.my.trainingbesenangpay01.module.miniproject.entity.Merchant;
import com.doku.my.trainingbesenangpay01.module.miniproject.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/merchant")
public class MerchantController
{
    private final MerchantService merchantService;

    @GetMapping(value = "/insert")
    public ResponseEntity<String> insert()
    {
        var merchant = Merchant.builder()
            .clientId("123456789")
            .name("Test Merchant")
            .build();

        merchantService.insert(merchant);

        return ResponseEntity.ok("Hello World");
    }
}
