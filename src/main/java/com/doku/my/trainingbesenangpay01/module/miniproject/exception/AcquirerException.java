package com.doku.my.trainingbesenangpay01.module.miniproject.exception;

import com.doku.my.trainingbesenangpay01.module.miniproject.enums.SnapResponse;
import lombok.Getter;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Getter
public class AcquirerException extends RuntimeException
{
    private final SnapResponse snapResponse;

    public AcquirerException(SnapResponse snapResponse)
    {
        super(snapResponse.name());
        this.snapResponse = snapResponse;
    }

    public AcquirerException(SnapResponse snapResponse, String message)
    {
        super(message);
        this.snapResponse = snapResponse;
    }
}
