package com.test.apijavaspringboot.infrastructure.repository;

import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Client, Integer> {

    boolean existsByCpf(String cpf);

    Optional<Client> findByCpfContains(String cpf);

}
