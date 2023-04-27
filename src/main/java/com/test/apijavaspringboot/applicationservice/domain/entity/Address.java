package com.test.apijavaspringboot.applicationservice.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "^\\d{5}(-\\d{3})?$", message = "cep: deve estar no formato '12345678' ou '12345-678'")
    private String cep;
    @NotBlank(message = "houseNumber: Não pode ser vazio ou nulo")
    private String houseNumber;
    private String complement;
    @NotBlank(message = "street: Não pode ser vazio ou nulo")
    private String street;
    @NotBlank(message = "neighborhood: Não pode ser vazio ou nulo")
    private String neighborhood;
    @NotBlank(message = "state: Não pode ser vazio ou nulo")
    private String state;
    @OneToOne(mappedBy = "address")
    private Client client;

    public Address() {}

    public Address(String cep, String houseNumber, String complement, String street, String neighborhood, String state) {
        this.cep = cep;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
