package com.test.apijavaspringboot.applicationservice.clientsservice;

import com.test.apijavaspringboot.applicationservice.domain.entity.Address;
import com.test.apijavaspringboot.applicationservice.domain.entity.Client;
import com.test.apijavaspringboot.infrastructure.apiclients.ViaCepApiClient;
import com.test.apijavaspringboot.infrastructure.apiclients.dto.AddressDto;
import com.test.apijavaspringboot.infrastructure.repository.ClientsRepository;
import com.test.apijavaspringboot.presentation.dto.ClientDto;
import com.test.apijavaspringboot.presentation.handler.Execpetion.ClientNotCreatedExeception;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreateClients {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClients.class);

    @Autowired
    private ClientsRepository repository;
    @Autowired
    private ViaCepApiClient viaCepApiClient;

    public Client create(@Valid ClientDto clientDTO) throws ValidationException {
        try {
            LOGGER.info("Iniciando");

            if (repository.existsByCpf(clientDTO.cpf())) {
                String error = String.format("Cpf %s já existente", clientDTO.cpf());
                LOGGER.error(error);
                throw new ClientNotCreatedExeception(error);
            }

            LOGGER.info("Consultando o CEP");
            AddressDto addressDto = viaCepApiClient.getCep(clientDTO.cep());

            LOGGER.info("Instanciando Address");
            Address address = new Address(
                    clientDTO.cep(), clientDTO.houseNumber(), clientDTO.complement()
                    , addressDto.logradouro(), addressDto.bairro(), addressDto.uf()
            );

            LOGGER.info("Instanciando Client");
            Client client = new Client(
                    clientDTO.name(), clientDTO.cpf(), clientDTO.birthDate(), address
            );

            LOGGER.info("Registrando usuário no banco");
            return repository.save(client);

        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

            for (ConstraintViolation<?> violation : violations) {
                String error = violation.getMessage();
                LOGGER.error(String.valueOf(error.getClass()));
                throw new ClientNotCreatedExeception(error);
            }

            return null;
        }

    }

}
