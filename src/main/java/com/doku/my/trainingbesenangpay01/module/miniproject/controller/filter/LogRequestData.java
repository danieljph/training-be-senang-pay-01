package com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter;

import lombok.Data;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

/**
 * Modified by Daniel Joi Partogi Hutapea
 *
 * @author Syifa Nur Isman
 */
@Data
public class LogRequestData
{
    private int httpStatus;

    private String httpMethod;
    private String path;

    private MultiValueMap<String, String> requestHeaders;
    private String requestBody;

    private MultiValueMap<String, String> responseHeaders;
    private String responseBody;

    private String executeIn;

    public void setPath(String path, String queryString)
    {
        this.path = queryString==null || queryString.isBlank()?
            path : path + "?" + queryString;
    }

    @Override
    public String toString()
    {
        return "HTTP Logs:\n" +
            "Status       = " + httpStatus + '\n' +
            "Method       = " + httpMethod + '\n' +
            "Path         = " + path + '\n' +
            "Req Headers  = " + Optional.ofNullable(requestHeaders).map(Object::toString).orElse(null) + '\n' +
            "Req Body     = " + requestBody + '\n' +
            "Resp Headers = " + Optional.ofNullable(responseHeaders).map(Object::toString).orElse(null) + '\n' +
            "Resp Body    = " + responseBody + '\n' +
            "Execute-In   = " + executeIn;
    }
}
