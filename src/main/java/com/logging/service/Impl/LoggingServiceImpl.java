package com.logging.service.Impl;

import com.logging.service.ILoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoggingServiceImpl implements ILoggingService {

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) {

        StringBuilder stringBuilder = new StringBuilder();


        Map<String, String> parameters = buildParametersMap(httpServletRequest);

        stringBuilder.append("REQUEST ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
        stringBuilder.append("headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");

        if (!parameters.isEmpty()) {
            stringBuilder.append("parameters=[").append(parameters).append("] \n");
        }

        if (body != null) {
            stringBuilder.append("body=[" + body + "]");
        }

        log.info(stringBuilder.toString());
    }

    @Override
    public void logResponse(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object body) {

        StringBuilder stringBuilder = new StringBuilder();


        Map<String, String> parameters = buildParametersMap(servletRequest);

        stringBuilder.append("RESPONSE ");
        stringBuilder.append("method=[").append(servletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(servletRequest.getRequestURI()).append("] ");
        stringBuilder.append("headers=[").append(buildHeadersMap(servletRequest)).append("] ");

        if (!parameters.isEmpty()) {
            stringBuilder.append("parameters=[").append(parameters).append("] \n");
        }

        if (body != null) {
            stringBuilder.append("body=[" + body + "]");
        }

        log.info(stringBuilder.toString());
    }


    public Map<String, String> buildParametersMap(HttpServletRequest httpServletRequest) {
        Map<String, String> ret =new HashMap<>();
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = (String) parameterNames.nextElement();
            String val = httpServletRequest.getParameter(key);
            ret.put(key, val);
        }
        return ret;
    }
    public String buildHeadersMap(HttpServletRequest httpServletRequest) {
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        StringBuilder ret= new StringBuilder();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                ret.append(httpServletRequest.getHeader(headerNames.nextElement()));
            }
        }
        return ret.toString();
    }

}