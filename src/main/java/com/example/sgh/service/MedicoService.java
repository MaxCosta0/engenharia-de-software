package com.example.sgh.service;

import com.example.sgh.controller.dto.NovoMedicoRequest;
import com.example.sgh.model.Medico;
import com.example.sgh.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodosMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> detalharMedico(Long idMedico) {
        return medicoRepository.findById(idMedico);
    }

    public Medico alterarMedico(Long idMedico, NovoMedicoRequest novoMedicoRequest) {
        Optional<Medico> medicoEncontrado = medicoRepository.findById(idMedico);

        if (medicoEncontrado.isEmpty()) {
            return null;
        }

        Medico medico = novoMedicoRequest.toModel();
        medico.setIdMedico(medicoEncontrado.get().getIdMedico());

        return cadastrarMedico(medico);
    }

    public boolean deletarMedico(Long idMedico) {
        Optional<Medico> medicoEncontrado = medicoRepository.findById(idMedico);

        if (medicoEncontrado.isEmpty()) {
            return false;
        }

        medicoRepository.deleteById(idMedico);
        return true;
    }


}
