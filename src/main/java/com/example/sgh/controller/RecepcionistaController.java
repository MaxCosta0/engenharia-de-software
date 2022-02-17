package com.example.sgh.controller;

import com.example.sgh.controller.dto.DetalhesRecepcionista;
import com.example.sgh.controller.dto.NovoRecepcionistaRequest;
import com.example.sgh.model.Recepcionista;
import com.example.sgh.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recepcionistas")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaService recepcionistaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid NovoRecepcionistaRequest novoRecepcionistaRequest){
        Recepcionista recepcionista = novoRecepcionistaRequest.toModel();
        recepcionistaService.cadastrarRecep(recepcionista);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<DetalhesRecepcionista> listarRecep() {
        List<Recepcionista> recepcionistas = recepcionistaService.listarTodosRecep();
        List<DetalhesRecepcionista> detalhesRecep = DetalhesRecepcionista.aPartirDe(recepcionistas);
        return detalhesRecep;
    }
    @GetMapping("/{idRecep}")
    public ResponseEntity<DetalhesRecepcionista> detalharRecep(@PathVariable("idRecep") Long idRecep) {
        Optional<Recepcionista> recepEncontrado = recepcionistaService.listarRecep(idRecep);

        if(recepEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        DetalhesRecepcionista detalhesRecepEncontrado = DetalhesRecepcionista.aPartirDe(recepEncontrado.get());
        return ResponseEntity.ok(detalhesRecepEncontrado);
    }

    @PatchMapping("/{idRecep}")
    public ResponseEntity<DetalhesRecepcionista> alternarRecep(@PathVariable("idRecep") Long idRecep, @RequestBody @Valid NovoRecepcionistaRequest novoRecepcionistaRequest) {
        Recepcionista recepAlterado = recepcionistaService.alterarRecep(idRecep, novoRecepcionistaRequest);

        if(recepAlterado == null){
            return ResponseEntity.notFound().build();
        }

        DetalhesRecepcionista detalhesRecep = DetalhesRecepcionista.aPartirDe(recepAlterado);
        return ResponseEntity.ok(detalhesRecep);
    }



    @DeleteMapping("/{idRecep}")
    public ResponseEntity<Void> deletarRecep(@PathVariable("idRecep") Long idRecep) {
        boolean recepDeletado = recepcionistaService.deletarRecep(idRecep);

        if(!recepDeletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
