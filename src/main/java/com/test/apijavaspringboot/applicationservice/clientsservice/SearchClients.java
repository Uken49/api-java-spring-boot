package com.test.apijavaspringboot.applicationservice.clientsservice;

import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.infrastructure.repository.ClientsRepository;
import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchClients {

    @Autowired
    private ClientsRepository repository;

    public Client searchById(Integer id) throws ClientNotFoundException {
        return repository.findById(id).orElseThrow(
                  () -> new ClientNotFoundException(String.format("Usuário com id '%d' não existe", id))
        );
    }

    public Client searchByCpf(String cpf) throws ClientNotFoundException {
        return repository.findByCpfContains(cpf).orElseThrow(
                () -> new ClientNotFoundException(String.format("Usuário com cpf '%s' não existe", cpf.replace("{","")))
        );
    }
}
