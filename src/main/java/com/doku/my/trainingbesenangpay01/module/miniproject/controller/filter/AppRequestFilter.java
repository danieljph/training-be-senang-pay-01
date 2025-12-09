package com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
@Component
@RequiredArgsConstructor
@Order(0)
public class AppRequestFilter extends OncePerRequestFilter
{
    private static final AppAntPathMatcher PATH_MATCHER = new AppAntPathMatcher();

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Value("${app.request-filter.exclude-paths: /**/actuator/**}")
    private List<String> excludePaths;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest servletRequest, @NonNull HttpServletResponse servletResponse, @NonNull FilterChain filterChain) throws ServletException, IOException
    {
        var stopWatch = new StopWatch();
        stopWatch.start();

        log.debug("doFilterInternal - BEGIN");
        log.info("HTTP Request Received: [{}] {}", servletRequest.getMethod(), generatePath(servletRequest.getRequestURI(), servletRequest.getQueryString()));

        var servletRequestWrapper = new ContentCachingRequestWrapper(servletRequest);
        var servletResponseWrapper = new ContentCachingResponseWrapper(servletResponse);

        boolean logRequestEnabled = false;

        try
        {
            var handlerExecutionChain = requestMappingHandlerMapping.getHandler(servletRequest);

            if(handlerExecutionChain != null && handlerExecutionChain.getHandler() instanceof HandlerMethod handlerMethod)
            {
                var method = handlerMethod.getMethod();
                var logRequest = method.getDeclaredAnnotation(LogRequest.class);

                if(logRequest != null)
                {
                    logRequestEnabled = logRequest.value();
                }
            }

            filterChain.doFilter(servletRequestWrapper, servletResponseWrapper);
        }
        catch(Exception ex)
        {
            log.warn("This filter is not working properly. Please investigate this issue further.", ex);
            // Proceed without invoking this filter...
            filterChain.doFilter(servletRequestWrapper, servletResponseWrapper);
        }
        finally
        {
            stopWatch.stop();

            if(logRequestEnabled)
            {
                logAndFlushContentCachingResponseWrapper(servletRequestWrapper, servletResponseWrapper, stopWatch);
            }

            /*
             * After ContentCachingResponseWrapper.copyBodyToResponse() executed, ContentCachingResponseWrapper.getContentAsByteArray() value will be reset. You won't get the response-body value anymore.
             * Make sure you call ContentCachingResponseWrapper.copyBodyToResponse() first to get all response-headers.
             */
            servletResponseWrapper.copyBodyToResponse();

            log.debug("doFilterInternal - END");
        }
    }

    private String generatePath(String path, String queryString)
    {
        return queryString==null || queryString.isBlank()?
            path : path + "?" + queryString;
    }

    private void logAndFlushContentCachingResponseWrapper(ContentCachingRequestWrapper servletRequestWrapper, ContentCachingResponseWrapper servletResponseWrapper, StopWatch stopWatch) throws IOException
    {
        var requestBody = new String(servletRequestWrapper.getContentAsByteArray(), servletRequestWrapper.getCharacterEncoding());
        var responseBody = new String(servletResponseWrapper.getContentAsByteArray(), servletResponseWrapper.getCharacterEncoding());

        var logRequestData = new LogRequestData();
        logRequestData.setHttpStatus(servletResponseWrapper.getStatus());
        logRequestData.setHttpMethod(servletRequestWrapper.getMethod());
        logRequestData.setPath(servletRequestWrapper.getRequestURI(), servletRequestWrapper.getQueryString());
        logRequestData.setRequestHeaders(getRequestHeaders(servletRequestWrapper));
        logRequestData.setRequestBody(requestBody);
        logRequestData.setResponseHeaders(getResponseHeaders(servletResponseWrapper));
        logRequestData.setResponseBody(responseBody);
        logRequestData.setExecuteIn(Duration.ofMillis(stopWatch.getTotalTimeMillis()).toString());
        logger.info(logRequestData);
    }

    private MultiValueMap<String, String> getRequestHeaders(HttpServletRequest servletRequest)
    {
        var requestHeaders = new LinkedMultiValueMap<String, String>();
        var headerNames = servletRequest.getHeaderNames();

        while(headerNames.hasMoreElements())
        {
            var headerName = headerNames.nextElement();
            var headerValues = servletRequest.getHeaders(headerName);

            while(headerValues.hasMoreElements())
            {
                requestHeaders.add(headerName, headerValues.nextElement());
            }
        }

        return requestHeaders;
    }

    @SuppressWarnings("DuplicatedCode")
    private MultiValueMap<String, String> getResponseHeaders(HttpServletResponse servletResponse)
    {
        var responseHeaders = new LinkedMultiValueMap<String, String>();
        var headerNames = servletResponse.getHeaderNames();

        if(headerNames!=null)
        {
            for(var headerName : headerNames)
            {
                responseHeaders.addAll(headerName, new ArrayList<>(servletResponse.getHeaders(headerName)));
            }
        }

        return responseHeaders;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest servletRequest)
    {
        var shouldNotFilter = excludePaths.stream().anyMatch(it -> PATH_MATCHER.match(it, servletRequest.getServletPath()));
        log.debug("Servlet Path: {} - (shouldNotFilter: {})", servletRequest.getServletPath(), shouldNotFilter);
        return excludePaths.stream().anyMatch(it -> PATH_MATCHER.match(it, servletRequest.getServletPath()));
    }
}
