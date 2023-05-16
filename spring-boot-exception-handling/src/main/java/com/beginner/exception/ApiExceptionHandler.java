package com.beginner.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntitysNotFoundException.class})
    public String entityNotFound() {
        return "Record not found";
    }

}
