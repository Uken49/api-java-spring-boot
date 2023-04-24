//package com.test.apijavaspringboot.infrastructure.repository.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//
//@Entity
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @NotBlank(message = "houseNumber: Não pode ser vazio ou nulo")
//    private String houseNumber;
//    private String complement;
//    @NotBlank(message = "street: Não pode ser vazio ou nulo")
//    private String street;
//    @NotBlank(message = "neighborhood: Não pode ser vazio ou nulo")
//    private String neighborhood;
//    @NotBlank(message = "state: Não pode ser vazio ou nulo")
//    private String state;
//    @OneToOne(mappedBy = "address")
//    private Client client;
//}
