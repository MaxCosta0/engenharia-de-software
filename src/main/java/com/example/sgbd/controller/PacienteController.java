package com.example.sgbd.controller;

import com.example.sgbd.model.Paciente;
import com.example.sgbd.controller.dto.NovoPacienteRequest;
import com.example.sgbd.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoPacienteRequest novoPacienteRequest){

        Paciente paciente = novoPacienteRequest.toModel();
        pacienteService.save(paciente);
        return ResponseEntity.ok().build();
    }

}
