package com.test.apijavaspringboot.presentation.handler;

import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerExecpetionAdvice {

    private ProblemDetail builderProblemDetail(
            String title, HttpStatus status, String detail
    ){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,detail);

        problemDetail.setTitle(title);
        problemDetail.setType(URI.create(""));
        problemDetail.setProperty("timestamp" , LocalDateTime.now());

        return problemDetail;
    }

    @ExceptionHandler({ValidationException.class})
    public ProblemDetail clientNotCreated(ValidationException ve){

        return builderProblemDetail(
                "Usuário não pôde ser criado"
                ,HttpStatus.BAD_REQUEST
                , ve.getMessage()
        );
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ProblemDetail clientNotFound(ClientNotFoundException cnfe){

        return builderProblemDetail(
                "Usuário não encontrado"
                ,HttpStatus.NOT_FOUND
                , cnfe.getMessage()
        );
    }

}
