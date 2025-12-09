package com.doku.my.trainingbesenangpay01.module.miniproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InquiryRequest
{
    @NotBlank @Size(max = 128) private String acquirerRequestId;
    @NotBlank @Size(max = 28) private String virtualAccountNo;

    private Map<String, Object> additionalInfo;
}
