package com.doku.my.trainingbesenangpay01.kmsaliyun.config.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Getter @Setter
@Configuration
@ConfigurationProperties(prefix = "kms-aliyun")
public class KmsAliyunProperties
{
    private ClientConfig clientConfig = new ClientConfig();

    @Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ClientConfig
    {
        private String protocol = "https"; // The connection protocol. Set the value to https. KMS supports connections only over HTTPS.
        private String endpoint = "<your KMS Instance Id>.cryptoservice.kms.aliyuncs.com"; // The endpoint of your KMS instance. Set the value in the following format: <ID of your KMS instance >.cryptoservice.kms.aliyuncs.com.

        private String clientKeyContent = "<your client key>"; // The content of the client key file.
        private String clientKeyPass = "<your client key password>"; // The password of the client key file.

        private String caCertContent = "<The DKMS instance CA certificates content>"; // The content of the CA certificate.
    }
}
