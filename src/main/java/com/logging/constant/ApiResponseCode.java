package com.logging.constant;

import org.springframework.http.HttpStatus;

public enum ApiResponseCode {

    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND"),
    FOUND(HttpStatus.FOUND, "FOUND"),
    UNKNOWN_ERROR(HttpStatus.NOT_IMPLEMENTED, "NOT_IMPLEMENTED");

    ApiResponseCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    };

    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
