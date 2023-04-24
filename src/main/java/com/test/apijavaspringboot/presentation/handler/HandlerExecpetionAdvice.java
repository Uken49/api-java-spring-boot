package com.test.apijavaspringboot.presentation.handler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class HandlerExecpetionAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    public ProblemDetail handleTest(ClientNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

        problemDetail.setTitle("Usuário não existe");
        problemDetail.setProperty("timestamp" , Instant.now());

        return problemDetail;
    }

}
