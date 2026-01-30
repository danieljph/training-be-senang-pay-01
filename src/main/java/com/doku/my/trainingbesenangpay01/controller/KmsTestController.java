package com.doku.my.trainingbesenangpay01.controller;

import com.doku.my.trainingbesenangpay01.kmsaliyun.KmsAliyunService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

import static java.security.CryptoPrimitive.SECURE_RANDOM;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
@RequiredArgsConstructor()
@RequestMapping("/kms")
@RestController
public class KmsTestController
{
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private final KmsAliyunService kmsAliyunService;

    @GetMapping("/encrypt")
    public ResponseEntity<String> encrypt()
    {
        var result = kmsAliyunService.encrypt("key-idy669895a7o59qf2gg5f", randomBytes(32));
        log.info("Result: {}", new String(result.getCiphertextBlob()));

        return ResponseEntity.ok("Success");
    }

    public static byte[] randomBytes(int bytesLength)
    {
        var result = new byte[bytesLength];
        SECURE_RANDOM.nextBytes(result);
        return result;
    }
}
