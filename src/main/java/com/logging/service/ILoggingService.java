package com.logging.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILoggingService {
    void logRequest(HttpServletRequest httpServletRequest, Object body);

    void logResponse(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object body);
}
