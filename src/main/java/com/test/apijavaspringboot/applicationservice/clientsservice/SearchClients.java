package com.test.apijavaspringboot.applicationservice.clientsservice;

import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.infrastructure.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchClients {

    @Autowired
    private ClientsRepository repository;

    public Optional<Client> searchById(Integer id){
        Optional<Client> search = repository.findById(id);

        if (search.isEmpty())
            return null;

        return search;
    }

//    public Optional<Client> searchByCpf(String cpf){
//        Optional<Client> search = repository.findByCpfContains(cpf);
//
//        if (search.isEmpty())
//            return null;
//
//        return search;
//    }
}
