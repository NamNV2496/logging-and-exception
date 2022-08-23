package com.logging.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// create a flag to control on application.yml
@ConditionalOnProperty(name = "spring.logRequestResponse.enabled", havingValue = "true")
@Component
@RequiredArgsConstructor
public class LoggingWebConfig implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;
    // to exclude printing swagger log
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).excludePathPatterns("/swagger-ui.html");
    }
}

