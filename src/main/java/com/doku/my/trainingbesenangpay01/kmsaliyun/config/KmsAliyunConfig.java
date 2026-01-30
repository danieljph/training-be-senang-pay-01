package com.doku.my.trainingbesenangpay01.kmsaliyun.config;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.sdk.Client;
import com.doku.my.trainingbesenangpay01.kmsaliyun.config.properties.KmsAliyunProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
@Configuration
public class KmsAliyunConfig
{
    @Bean
    public Client kmsAliyunClient(KmsAliyunProperties kmsAliyunProperties)
    {
        try
        {
            log.debug("KMS endpoint : {}", kmsAliyunProperties.getClientConfig().getEndpoint());

            var config = new Config();
            config.setProtocol(kmsAliyunProperties.getClientConfig().getProtocol());
            config.setEndpoint(kmsAliyunProperties.getClientConfig().getEndpoint());
            config.setClientKeyContent(kmsAliyunProperties.getClientConfig().getClientKeyContent());
            config.setPassword(kmsAliyunProperties.getClientConfig().getClientKeyPass());
            config.setCa(kmsAliyunProperties.getClientConfig().getCaCertContent());

            return new Client(config);
        }
        catch(Exception ex)
        {
            var errorInfo = String.format("Failed to create KMS-Aliyun Client. Cause: %s - %s", ex.getClass().getSimpleName(), ex.getMessage());
            throw new RuntimeException(errorInfo, ex);
        }
    }
}
