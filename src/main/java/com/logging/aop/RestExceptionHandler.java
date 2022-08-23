package com.logging.aop;

import com.logging.config.MessageUtils;
import com.logging.constant.ApiResponseCode;
import com.logging.domain.BodyResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageUtils messageUtils;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BodyResponseDTO> handleUnCaughtException(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
        String i18nMessage = messageUtils.populate(ApiResponseCode.UNKNOWN_ERROR.getMessage());
        BodyResponseDTO bodyResponseDTO = new BodyResponseDTO();
        bodyResponseDTO.setHttpStatus(ApiResponseCode.UNKNOWN_ERROR.getStatus());
        bodyResponseDTO.setMessage(i18nMessage);
        log.info(bodyResponseDTO.toString());
        return new ResponseEntity<>(bodyResponseDTO, ApiResponseCode.UNKNOWN_ERROR.getStatus());
    }
}

//    public static ResponseEntity<BodyResponseDTO<Object>> wrapInternalErrorResponse(String i18nMessage) {
//        return getResponse(ApiResponseCode.UNKNOWN_ERROR.getStatus(), ApiResponseCode.UNKNOWN_ERROR.getCode(), i18nMessage);
//    }
//
//    public static ResponseEntity<BodyResponseDTO<Object>> wrapInternalErrorResponse(RestException restException, String i18nMessage) {
//        return getResponse(restException.getRestError().getStatus(), restException.getRestError().getCode(), i18nMessage);
//    }
//
//    public static <T> ResponseEntity<BodyResponseDTO<T>> getResponse(HttpStatus status, String code, String message) {
//        BodyResponseDTO<T> bodyResponse = new BodyResponseDTO<>(code, message);
//        return new ResponseEntity<>(bodyResponse, status);
//    }
