package com.logging.config;

import com.logging.service.ILoggingService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    ILoggingService loggingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(HttpMethod.GET.name())) {
            loggingService.logRequest(request, null);
        }
        String tranId;
        String id = request.getHeader("X-Header-Id");
        if (Objects.nonNull(id)) {
            tranId = id;
        } else {
            tranId = UUID.randomUUID().toString();
        }
        MDC.put("transactionId", tranId);
        return true;
    }
}