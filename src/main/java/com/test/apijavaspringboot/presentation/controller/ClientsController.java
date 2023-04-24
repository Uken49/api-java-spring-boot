package com.test.apijavaspringboot.presentation.controller;

import com.test.apijavaspringboot.applicationservice.clientsservice.CreateClients;
import com.test.apijavaspringboot.applicationservice.clientsservice.SearchClients;
import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.presentation.dto.CreateClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private CreateClients createClients;
    @Autowired
    private SearchClients searchClients;

    @PostMapping
    public ResponseEntity<Client> create(@Valid @RequestBody CreateClientDto client){
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(createClients.create(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> list(@PathVariable Integer id){

        Optional<Client> response = searchClients.searchById(id);

        if (response == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
