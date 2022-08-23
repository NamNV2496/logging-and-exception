package com.logging.config;

import com.logging.service.ILoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ConditionalOnProperty(name = "spring.logRequestResponse.enabled", havingValue = "true")
@ControllerAdvice
public class LogResponseBodyAdviceAdaper implements ResponseBodyAdvice<Object> {

    @Autowired
    ILoggingService loggingService;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest && response instanceof ServletServerHttpResponse) {
            loggingService.logResponse(((ServletServerHttpRequest) request).getServletRequest(),
                    ((ServletServerHttpResponse) response).getServletResponse(), body);
        }
        return body;
    }
}