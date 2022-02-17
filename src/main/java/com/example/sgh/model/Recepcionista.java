package com.example.sgh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recepcionista")
    private String idRecep;

    @NotNull
    @NotBlank
    @Column(name = "nome_recepcionista")
    private String nomeRecep;

    @NotNull
    @Column(name = "data_recepcionista")
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank
    @Column(name = "cpf_recepcionista")
    private String cpfRecep;

    @NotNull
    @NotBlank
    @Column(name = "telefone_recepcionista")
    private String telefoneRecep;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "email_recepcionista")
    private String emailRecep;

    @NotNull
    @Column(name = "senha_recepcionista")
    private String senhaRecep;

    public Recepcionista(String nomeRecep,LocalDate dataNascimento, String cpfRecep, String telefoneRecep, String emailRecep, String senhaRecep){
        this.nomeRecep = nomeRecep;
        this.dataNascimento = dataNascimento;
        this.cpfRecep = cpfRecep;
        this.telefoneRecep = telefoneRecep;
        this.emailRecep = emailRecep;
        this.senhaRecep = senhaRecep;
    }
}
