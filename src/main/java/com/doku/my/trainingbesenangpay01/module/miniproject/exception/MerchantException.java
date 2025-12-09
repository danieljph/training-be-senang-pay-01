package com.doku.my.trainingbesenangpay01.module.miniproject.exception;

import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import lombok.Getter;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Getter
public class MerchantException extends RuntimeException
{
    private final SnapResponse snapResponse;

    public MerchantException(SnapResponse snapResponse)
    {
        super(snapResponse.name());
        this.snapResponse = snapResponse;
    }

    public MerchantException(SnapResponse snapResponse, String message)
    {
        super(message);
        this.snapResponse = snapResponse;
    }
}
