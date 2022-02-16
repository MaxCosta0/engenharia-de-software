package com.example.sgh.controller.dto;

import com.example.sgh.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class DetalhesPaciente {

    @NotNull @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull @NotBlank
    private String cpf;

    @NotNull @NotBlank
    private String telefone;

    @NotNull @NotBlank @Email
    private String email;

    public static List<DetalhesPaciente> aPartirDe(List<Paciente> pacientes) {
        List<DetalhesPaciente> detalhesPacientes = new ArrayList<DetalhesPaciente>();

        pacientes.forEach(paciente -> {
            detalhesPacientes.add(new DetalhesPaciente(paciente.getNome(), paciente.getDataNascimento(), paciente.getCpf(), paciente.getTelefone(), paciente.getEmail()));
        });

        return detalhesPacientes;
    }

    public static DetalhesPaciente aPartirDe(Paciente paciente){
       return new DetalhesPaciente(
                        paciente.getNome(),
                        paciente.getDataNascimento(),
                        paciente.getCpf(),
                        paciente.getTelefone(),
                        paciente.getEmail()
                );
    }

}
