package com.example.sgh.controller.dto;

import com.example.sgh.model.Recepcionista;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class NovoRecepcionistaRequest {

    @NotNull
    @NotBlank
    private String nomeRecep;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank
    private String cpfRecep;

    @NotNull
    @NotBlank
    private String telefoneRecep;

    @NotNull
    @NotBlank
    @Email
    private String emailRecep;

    @NotNull
    private String senhaRecep;

    public NovoRecepcionistaRequest(String nome, LocalDate dataNascimento, String cpfRecep, String telefoneRecep, String emailRecep, String senhaRecep) {
        this.nomeRecep = nomeRecep;
        this.dataNascimento = LocalDate.now();
        this.cpfRecep = cpfRecep;
        this.telefoneRecep = telefoneRecep;
        this.emailRecep = emailRecep;
        this.senhaRecep = senhaRecep;
    }

    public Recepcionista toModel(){
        return new Recepcionista(this.nomeRecep, this.dataNascimento, this.cpfRecep, this.telefoneRecep, this.emailRecep, this.senhaRecep);
    }
}
