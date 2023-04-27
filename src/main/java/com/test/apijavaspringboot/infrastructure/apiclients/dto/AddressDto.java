package com.test.apijavaspringboot.infrastructure.apiclients.dto;

public record AddressDto(
        String cep, String logradouro
        , String bairro, String uf
) {


}