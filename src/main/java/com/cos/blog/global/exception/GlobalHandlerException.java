package com.cos.blog.global.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = Exception.class)
    public String handleArgsException(Exception e) {
        return e.getLocalizedMessage();
    }
}
