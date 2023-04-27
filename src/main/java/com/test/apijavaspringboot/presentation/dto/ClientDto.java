package com.test.apijavaspringboot.presentation.dto;

import java.time.LocalDate;

public record ClientDto(
        String name, String cpf, LocalDate birthDate, String houseNumber
        , String cep, String complement
) {

}
