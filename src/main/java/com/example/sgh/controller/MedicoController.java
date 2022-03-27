package com.example.sgh.controller;


import com.example.sgh.controller.dto.DetalhesMedico;
import com.example.sgh.controller.dto.NovoMedicoRequest;
import com.example.sgh.model.Medico;
import com.example.sgh.service.MedicoService;
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
        Optional<Medico> medicoEncontrado = medicoService.detalharMedico(idMedico);

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
