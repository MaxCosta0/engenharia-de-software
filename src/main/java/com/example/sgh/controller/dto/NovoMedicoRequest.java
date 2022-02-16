package com.example.sgh.controller.dto;

import com.example.sgh.model.Medico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoMedicoRequest {


    @NotNull
    @NotBlank
    private String nomeMedico;

    @NotNull
    @NotBlank
    private String especialidade;

    @NotNull
    @NotBlank
    private String cpfMedico;

    @NotNull
    @NotBlank
    private String telefoneMedico;

    @NotNull
    @NotBlank
    @Email
    private String emailMedico;

    @NotNull
    @NotBlank
    private String crm;

    @NotNull
    private String senhaMedico;

    public NovoMedicoRequest(String nomeMedico, String especialidade, String cpfMedico, String telefoneMedico, String emailMedico, String crm, String senhaMedico){
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.cpfMedico = cpfMedico;
        this.telefoneMedico = telefoneMedico;
        this.emailMedico = emailMedico;
        this.crm = crm;
        this.senhaMedico = senhaMedico;
    }

    public Medico toModel(){
        return new Medico(this.nomeMedico, this.especialidade, this.cpfMedico, this.telefoneMedico, this.emailMedico, this.crm, this.senhaMedico);
    }

}
