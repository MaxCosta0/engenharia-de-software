package com.example.sgbd.controller.dto;

import com.example.sgbd.model.Paciente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NovoPacienteRequest {

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

    public NovoPacienteRequest(String nome, LocalDate dataNascimento, String cpf, String telefone, String email, String senha) {
        this.nome = nome;
        this.dataNascimento = LocalDate.now();
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Paciente toModel(){
        return new Paciente(this.nome, this.dataNascimento, this.cpf, this.telefone, this.email, this.senha);
    }
}
