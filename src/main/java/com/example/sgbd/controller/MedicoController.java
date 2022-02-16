package com.example.sgbd.controller;


import com.example.sgbd.controller.dto.DetalhesMedico;
import com.example.sgbd.controller.dto.NovoMedicoRequest;
import com.example.sgbd.model.Medico;
import com.example.sgbd.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoMedicoRequest novoMedicoRequest){
        Medico medico = novoMedicoRequest.toModel();
        medicoService.cadastrarMedico(medico);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<DetalhesMedico> listarMedicos(){
        List<Medico> medicos = medicoService.listarTodosMedicos();
        List<DetalhesMedico> detalhesMedico = DetalhesMedico.aPartirDe(medicos);
        return detalhesMedico;
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<DetalhesMedico> detalharMedico(@PathVariable("idMedico") Long idMedico) {
        Optional<Medico> medicoEncontrado = medicoService.listarMedico(idMedico);

        if(medicoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DetalhesMedico detalhesMedicoEncontrado = DetalhesMedico.aPartirDe(medicoEncontrado.get());
        return ResponseEntity.ok(detalhesMedicoEncontrado);
    }

    @PatchMapping("/{idMedico}")
    public ResponseEntity<DetalhesMedico> alterarMedico(@PathVariable("idMedico") Long idMedico, @RequestBody @Valid NovoMedicoRequest novoMedicoRequest) {
        Medico medicoAlterado = medicoService.alterarMedico(idMedico, novoMedicoRequest);
        
        if(medicoAlterado == null){
            return ResponseEntity.notFound().build();
        }
        
        DetalhesMedico detalhesMedico = DetalhesMedico.aPartirDe(medicoAlterado);
        return ResponseEntity.ok(detalhesMedico);
    }
    
    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Void> deletarMedico(@PathVariable("idMedico") Long idMedico) {
        boolean medicoDeletado = medicoService.deletarMedico(idMedico);

        if(!medicoDeletado){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
