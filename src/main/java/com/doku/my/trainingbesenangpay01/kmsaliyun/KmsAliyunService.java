package com.doku.my.trainingbesenangpay01.kmsaliyun;

import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.EncryptRequest;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RequiredArgsConstructor
@Service
public class KmsAliyunService
{
    private final Client kmsAliyunClient;

    public EncryptResponse encrypt(String keyId, byte[] plaintext)
    {
        var encryptRequest = new EncryptRequest();
        encryptRequest.setKeyId(keyId);
        encryptRequest.setPlaintext(plaintext);
        return encrypt(encryptRequest);
    }

    public EncryptResponse encrypt(EncryptRequest encryptRequest)
    {
        try
        {
            return kmsAliyunClient.encrypt(encryptRequest);
        }
        catch(Exception ex)
        {
            var errorInfo = String.format("Failed to encrypt using KMS-Aliyun. Cause: %s - %s", ex.getClass().getSimpleName(), ex.getMessage());
            throw new RuntimeException(errorInfo, ex);
        }
    }

    public DecryptResponse decrypt(String keyId, String ciphertextBlobAsBase64, String ivAsBase64)
    {
        return decrypt(keyId, Base64.getDecoder().decode(ciphertextBlobAsBase64), Base64.getDecoder().decode(ivAsBase64));
    }

    public DecryptResponse decrypt(String keyId, byte[] ciphertextBlob, byte[] iv)
    {
        var decryptRequest = new DecryptRequest();
        decryptRequest.setKeyId(keyId);
        decryptRequest.setCiphertextBlob(ciphertextBlob);
        decryptRequest.setIv(iv);
        return decrypt(decryptRequest);
    }

    public DecryptResponse decrypt(DecryptRequest decryptRequest)
    {
        try
        {
            return kmsAliyunClient.decrypt(decryptRequest);
        }
        catch(Exception ex)
        {
            var errorInfo = String.format("Failed to decrypt using KMS-Aliyun. Cause: %s - %s", ex.getClass().getSimpleName(), ex.getMessage());
            throw new RuntimeException(errorInfo, ex);
        }
    }
}
