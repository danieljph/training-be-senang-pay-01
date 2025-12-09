package com.doku.my.trainingbesenangpay01.module.miniproject.controller.converter;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SuperBuilder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SnapHttpHeaders
{
    public static final String X_PARTNER_ID = "X-PARTNER-ID";

    @NotBlank private String xPartnerId;
}
