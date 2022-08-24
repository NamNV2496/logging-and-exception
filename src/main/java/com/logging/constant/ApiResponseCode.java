package com.logging.constant;

import org.springframework.http.HttpStatus;

public enum ApiResponseCode {

    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "404"),
    FOUND(HttpStatus.FOUND, "FOUND", "417"),
    UNKNOWN_ERROR(HttpStatus.NOT_IMPLEMENTED, "NOT_IMPLEMENTED", "500");

    ApiResponseCode(HttpStatus status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    };

    private HttpStatus status;
    private String message;
    private String code;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    public String getCode() {
        return code;
    }
}
