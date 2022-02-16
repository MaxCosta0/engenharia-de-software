package com.example.sgbd.controller;

import com.example.sgbd.controller.dto.DetalhesPaciente;
import com.example.sgbd.model.Paciente;
import com.example.sgbd.controller.dto.NovoPacienteRequest;
import com.example.sgbd.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid NovoPacienteRequest novoPacienteRequest){

        Paciente paciente = novoPacienteRequest.toModel();
        pacienteService.salvar(paciente);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<DetalhesPaciente> listar(){
        List<Paciente> pacientes = pacienteService.listar();
        List <DetalhesPaciente> detalhesPaciente = DetalhesPaciente.aPartirDe(pacientes);
        return detalhesPaciente;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPaciente> detalhar(@PathVariable("id") Long id){
        Optional<Paciente> pacienteEncontrado = pacienteService.detalhar(id);

        if (pacienteEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DetalhesPaciente detalhesPacienteEncontrado = DetalhesPaciente.aPartirDe(pacienteEncontrado.get());

        return ResponseEntity.ok(detalhesPacienteEncontrado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalhesPaciente> alterar(@PathVariable("id") Long id, @RequestBody @Valid NovoPacienteRequest novoPacienteRequest){

        Paciente pacienteAlterado = pacienteService.alterar(id, novoPacienteRequest);

        if (pacienteAlterado == null) {
            return ResponseEntity.notFound().build();
        }

        DetalhesPaciente detalhesPaciente = DetalhesPaciente.aPartirDe(pacienteAlterado);

        return ResponseEntity.ok(detalhesPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        boolean pacienteDeletado = pacienteService.deletar(id);

        if(!pacienteDeletado){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
