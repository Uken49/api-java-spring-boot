package com.test.apijavaspringboot.presentation.dto;

import com.test.apijavaspringboot.applicationservice.domain.entity.Address;
import com.test.apijavaspringboot.applicationservice.domain.entity.Client;


public record SearchClientDto(
        Client client, Address address
) {


}
