package com.logging.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BodyResponseDTO {
    private HttpStatus httpStatus;
    private String message;
}
