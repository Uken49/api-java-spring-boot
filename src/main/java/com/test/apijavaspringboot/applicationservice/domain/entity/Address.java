package com.test.apijavaspringboot.applicationservice.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "houseNumber: Não pode ser vazio ou nulo")
    @NotNull
    private String houseNumber;
    private String complement;
    @NotBlank(message = "street: Não pode ser vazio ou nulo")
    @NotNull
    private String street;
    @NotBlank(message = "neighborhood: Não pode ser vazio ou nulo")
    @NotNull
    private String neighborhood;
    @NotBlank(message = "state: Não pode ser vazio ou nulo")
    @NotNull
    private String state;
    @OneToOne(mappedBy = "address")
    private Client client;

    public Address() {}

    public Address(String complement, String street, String houseNumber, String neighborhood, String state) {
        this.complement = complement;
        this.street = street;
        this.houseNumber = houseNumber;
        this.neighborhood = neighborhood;
        this.state = state;
    }

    public Integer getId() {
        return id;
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
