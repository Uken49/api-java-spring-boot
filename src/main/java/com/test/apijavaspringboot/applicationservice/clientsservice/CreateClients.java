package com.test.apijavaspringboot.applicationservice.clientsservice;

import com.test.apijavaspringboot.applicationservice.domain.entity.Address;
import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.infrastructure.apiclients.ViaCepApiClient;
import com.test.apijavaspringboot.infrastructure.apiclients.dto.ClientDto;
import com.test.apijavaspringboot.infrastructure.repository.ClientsRepository;
import com.test.apijavaspringboot.presentation.dto.CreateClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClients {

    @Autowired
    private ClientsRepository repository;
    @Autowired
    private ViaCepApiClient viaCepApiClient;

    public Client create(@Valid CreateClientDto clientDTO){

        ClientDto addressDto =  viaCepApiClient.getCep(clientDTO.cep());

        Address address = new Address(
                addressDto.complemento(), addressDto.logradouro(), "2"
                , addressDto.bairro(), addressDto.uf()
        );

        Client client = new Client(
                clientDTO.name(), clientDTO.cpf(), clientDTO.birthDate(), address
        );

        return repository.save(client);
    }
}
