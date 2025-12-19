package com.doku.my.trainingbesenangpay01.module.intermediate.controller.filter;

import com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter.AppAntPathMatcher;
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
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;
import java.util.List;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
@Component
@RequiredArgsConstructor
@Order(1)
public class AppRequestFilter1 extends OncePerRequestFilter
{
    private static final AppAntPathMatcher PATH_MATCHER = new AppAntPathMatcher();

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Value("${app.request-filter.exclude-paths: /**/actuator/**}")
    private List<String> excludePaths;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest servletRequest, @NonNull HttpServletResponse servletResponse, @NonNull FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            log.info("Before controller invocation.");
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("After controller invocation.");
        }
        catch(Exception ex)
        {
            log.warn("This filter is not working properly. Please investigate this issue further.", ex);
            // Proceed without invoking this filter...
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest servletRequest)
    {
        var shouldNotFilter = excludePaths.stream().anyMatch(it -> PATH_MATCHER.match(it, servletRequest.getServletPath()));
        log.debug("Servlet Path: {} - (shouldNotFilter: {})", servletRequest.getServletPath(), shouldNotFilter);
        return excludePaths.stream().anyMatch(it -> PATH_MATCHER.match(it, servletRequest.getServletPath()));
    }
}
