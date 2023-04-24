package com.test.apijavaspringboot.presentation.dto;

import java.time.LocalDate;

public record CreateClientDto(
        String name, String cpf, LocalDate birthDate, String cep
) {

}
