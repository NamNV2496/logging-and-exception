package com.logging.controller;

import com.logging.aop.RestException;
import com.logging.aop.RestExceptionHandler;
import com.logging.constant.ApiResponseCode;
import com.logging.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExampleController {
    @GetMapping("/hello")
    public String hello() {
//        log.info(String.valueOf(4/0));
//        throw new RestException(ApiResponseCode.UNKNOWN_ERROR);
        log.info("Hello");
        return "Hello";
    }

    @GetMapping("/person")
    public Person hello(@RequestBody Person person) {
        log.info(String.valueOf(person));
        return person;
    }
}
