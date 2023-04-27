package com.test.apijavaspringboot.applicationservice.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "name: Não pode ser vazio ou nulo")
    private String name;
    @CPF(message = "cpf: Deve conter apenas os digitos")
//    @Size(min = 11, max = 11, message = "cpf: Quantidade de digitos deve ser 11")
    private String cpf;
    @PastOrPresent(message = "birthDate: Não pode ser uma data no futuro")
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Address address;

    public Client() {}

    public Client(String name, String cpf, LocalDate birthDate, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
