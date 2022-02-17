package com.example.sgh.controller.dto;

import com.example.sgh.model.Paciente;
import com.example.sgh.model.Recepcionista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesRecepcionista {
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

    public static  List<DetalhesRecepcionista> aPartirDe(List<Recepcionista> recepcionistas) {
        List<DetalhesRecepcionista> detalhesRecepcionistas = new ArrayList<DetalhesRecepcionista>();

        recepcionistas.forEach(recepcionista -> {
            detalhesRecepcionistas.add(new DetalhesRecepcionista(recepcionista.getNomeRecep(), recepcionista.getDataNascimento(), recepcionista.getCpfRecep(), recepcionista.getTelefoneRecep(), recepcionista.getEmailRecep()));
        });

        return detalhesRecepcionistas;
    }

    public static DetalhesRecepcionista aPartirDe(Recepcionista recepcionista){
        return new DetalhesRecepcionista(
                recepcionista.getNomeRecep(),
                recepcionista.getDataNascimento(),
                recepcionista.getCpfRecep(),
                recepcionista.getTelefoneRecep(),
                recepcionista.getEmailRecep()
        );
    }
}
