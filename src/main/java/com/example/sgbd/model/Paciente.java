package com.example.sgbd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank
    private String cpf;

    @NotNull
    @NotBlank
    private String telefone;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    private String senha;


    public Paciente( String nome, LocalDate dataNascimento, String cpf, String telefone, String email, String senha) {        //TODO: receber data de nascimento
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
}
