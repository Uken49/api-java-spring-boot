//package com.test.apijavaspringboot.infrastructure.repository.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.PastOrPresent;
//import jakarta.validation.constraints.Size;
//import org.hibernate.validator.constraints.br.CPF;
//
//import java.time.LocalDate;
//
//@Entity
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @NotBlank(message = "name: Não pode ser vazio ou nulo")
//    private String name;
//    @CPF(message = "cpf: Deve conter apenas os digitos")
//    @Size(min = 11, max = 11, message = "cpf: Quantidade de digitos deve ser 11")
//    private String cpf;
//    @PastOrPresent(message = "birthDate: Não pode ser uma data no futuro")
//    @JsonFormat(pattern = "YYYY-MM-DD")
//    private LocalDate birthDate;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "id")
//    private Address address;
//}
