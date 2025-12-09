package com.doku.my.trainingbesenangpay01.module.jpa.dto;

import com.doku.my.trainingbesenangpay01.module.jpa.entity.MerchantStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Setter @Getter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class FindByIdResponse
{
    @NotBlank private Long id;
    @NotBlank private String name;
    @NotBlank private String clientId;
    @NotBlank private String clientSecret;
    @NotBlank private MerchantStatus status;
    @NotBlank private ZonedDateTime createdDate;
}
