package com.test.apijavaspringboot.infrastructure.apiclients;

import com.test.apijavaspringboot.infrastructure.apiclients.dto.AddressDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCepApiClient", url = "https://viacep.com.br/ws/")
public interface ViaCepApiClient {

    @GetMapping("{cep}/json/")
    AddressDto getCep(@Valid @PathVariable String cep);

}
