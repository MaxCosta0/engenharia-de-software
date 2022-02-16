package com.example.sgbd.controller.dto;

import com.example.sgbd.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesMedico {

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

    public static List<DetalhesMedico> aPartirDe(List<Medico> medicos) {
        List<DetalhesMedico> detalhesMedico = new ArrayList<DetalhesMedico>();

        medicos.forEach(medico -> {
            detalhesMedico.add(new DetalhesMedico(medico.getNomeMedico(), medico.getEspecialidade(), medico.getCpfMedico(), medico.getTelefoneMedico(), medico.getEmailMedico(), medico.getCrm()));
        });

        return detalhesMedico;
    }

    public static DetalhesMedico aPartirDe(Medico medico) {
        return new DetalhesMedico(
                medico.getNomeMedico(),
                medico.getEspecialidade(),
                medico.getCpfMedico(),
                medico.getTelefoneMedico(),
                medico.getEmailMedico(),
                medico.getCrm()
        );
    }
}
