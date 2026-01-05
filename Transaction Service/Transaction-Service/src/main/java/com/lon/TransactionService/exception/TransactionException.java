package com.lon.TransactionService.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionException {

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTimeException(RuntimeException ex){
        return ex.getMessage();
    }
}
