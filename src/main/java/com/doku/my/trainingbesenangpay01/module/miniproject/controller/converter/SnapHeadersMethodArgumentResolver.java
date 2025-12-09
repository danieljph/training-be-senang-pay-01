package com.doku.my.trainingbesenangpay01.module.miniproject.controller.converter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class SnapHeadersMethodArgumentResolver implements HandlerMethodArgumentResolver
{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameterAnnotation(SnapRequestHeader.class)!=null && methodParameter.getParameterType().isAssignableFrom(SnapHttpHeaders.class);
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter methodParameter, ModelAndViewContainer mavContainer, @NonNull NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception
    {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        SnapHttpHeaders snapHttpHeaders = new SnapHttpHeaders();
        snapHttpHeaders.setXPartnerId(request.getHeader(SnapHttpHeaders.X_PARTNER_ID));

        if(methodParameter.hasParameterAnnotation(Validated.class) || methodParameter.hasParameterAnnotation(Valid.class))
        {
            WebDataBinder binder = binderFactory.createBinder(webRequest, snapHttpHeaders,"snapHttpHeaders");
            binder.validate();
            BindingResult bindingResult = binder.getBindingResult();
            if(bindingResult.getErrorCount() > 0)
            {
                throw new MethodArgumentNotValidException(methodParameter, bindingResult);
            }
        }

        return snapHttpHeaders;
    }
}
