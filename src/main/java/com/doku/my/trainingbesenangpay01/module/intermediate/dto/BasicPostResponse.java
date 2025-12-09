package com.doku.my.trainingbesenangpay01.module.intermediate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Builder @Setter @Getter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class BasicPostResponse
{
    @NotBlank String message;

    @Size(max = 5) private String field1;
    @Max(10) private int field2;
    @NotNull private Boolean field3;

    private Amount amount;

    @Builder @Setter @Getter @NoArgsConstructor @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Amount
    {
        @JsonFormat(shape = JsonFormat.Shape.STRING) @NotNull private BigDecimal value;
        @NotBlank private String currency;
    }
}
