package com.example.sgh.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    @NotNull
    @NotBlank
    @Column(name = "nome_medico")
    private String nomeMedico;

    @NotNull
    @NotBlank
    @Column(name = "especialidade_medico")
    private String especialidade;

    @NotNull
    @NotBlank
    @Column(name = "cpf_medico")
    private String cpfMedico;

    @NotNull
    @NotBlank
    @Column(name = "telefone_medico")
    private String telefoneMedico;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "email_medico")
    private String emailMedico;

    @NotNull
    @NotBlank
    @Column(name = "crm_medico")
    private String crm;

    @NotNull
    @Column(name = "senha_medico")
    private String senhaMedico;

    public Medico(String nomeMedico, String especialidade, String cpfMedico, String telefoneMedico, String emailMedico, String crm, String senhaMedico){
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.cpfMedico = cpfMedico;
        this.telefoneMedico = telefoneMedico;
        this.emailMedico = emailMedico;
        this.crm = crm;
        this.senhaMedico = senhaMedico;
    }

}
