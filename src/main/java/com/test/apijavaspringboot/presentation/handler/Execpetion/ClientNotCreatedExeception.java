package com.test.apijavaspringboot.presentation.handler.Execpetion;

import jakarta.validation.ValidationException;

public class ClientNotCreatedExeception extends ValidationException {

    public ClientNotCreatedExeception(String message) {
        super(message);
    }

    public ClientNotCreatedExeception() {
    }
}
