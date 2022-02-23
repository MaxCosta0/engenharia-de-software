package com.example.sgh.service;

import com.example.sgh.controller.dto.NovoRecepcionistaRequest;
import com.example.sgh.model.Recepcionista;
import com.example.sgh.repository.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcionistaService {

    @Autowired
    private RecepcionistaRepository recepcionistaRepository;

    public Recepcionista cadastrarRecep(Recepcionista recepcionista){return recepcionistaRepository.save(recepcionista);}

    public List<Recepcionista> listarTodosRecep(){return recepcionistaRepository.findAll();}

    public Optional<Recepcionista> listarRecep(Long idRecep) {
        return recepcionistaRepository.findById(idRecep);
    }

    public Recepcionista alterarRecep(Long idRecep, NovoRecepcionistaRequest novoRecepcionistaRequest) {
        Optional<Recepcionista> recepEncontrado = recepcionistaRepository.findById(idRecep);

        if(recepEncontrado.isEmpty()){
            return null;
        }

        Recepcionista recepcionista = novoRecepcionistaRequest.toModel();
        recepcionista.setIdRecep(recepEncontrado.get().getIdRecep());

        return cadastrarRecep(recepcionista);
    }

    public boolean deletarRecep(Long idRecep) {
        Optional<Recepcionista> recepEncontrado = listarRecep(idRecep);

        if(recepEncontrado.isEmpty()) {
            return false;
        }

        recepcionistaRepository.deleteById(idRecep);
        return true;
    }
}
