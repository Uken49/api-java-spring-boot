package com.test.apijavaspringboot.presentation.controller;

import com.test.apijavaspringboot.applicationservice.clientsservice.CreateClients;
import com.test.apijavaspringboot.applicationservice.clientsservice.SearchClients;
import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.presentation.dto.ClientDto;
import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotCreatedExeception;
import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private CreateClients createClients;
    @Autowired
    private SearchClients searchClients;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody ClientDto client) throws ClientNotCreatedExeception {
        return createClients.create(client);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Client selectFromCpf(@RequestBody String cpf) throws ClientNotFoundException {
        return searchClients.searchByCpf(cpf);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client selectFromId(@PathVariable Integer id) throws ClientNotFoundException {
        return searchClients.searchById(id);
    }


}
