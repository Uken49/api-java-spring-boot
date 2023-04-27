//package com.test.apijavaspringboot.infrastructure.repository.entity;
//
//import com.test.apijavaspringboot.applicationservice.domain.entity.Address;
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String name;
//    private String cpf;
//    private LocalDate birthDate;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "id")
//    private Address address;
//
//}
