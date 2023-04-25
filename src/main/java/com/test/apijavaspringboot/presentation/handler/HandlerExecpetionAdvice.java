package com.test.apijavaspringboot.presentation.handler;

import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotCreatedExeception;
import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class HandlerExecpetionAdvice {

    @ExceptionHandler(ClientNotCreatedExeception.class)
    public ProblemDetail clientNotCreated(ClientNotCreatedExeception e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());

        problemDetail.setType(URI.create(""));
        problemDetail.setTitle("Usuário não pôde ser criado");
        problemDetail.setProperty("timestamp" , Instant.now());

        return problemDetail;
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ProblemDetail clientNotFound(ClientNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

        problemDetail.setType(URI.create(""));
        problemDetail.setTitle("Usuário não encontrado");
        problemDetail.setProperty("timestamp" , Instant.now());

        return problemDetail;
    }

}
