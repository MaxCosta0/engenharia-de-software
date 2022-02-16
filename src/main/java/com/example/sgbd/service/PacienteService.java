package com.example.sgbd.service;

import com.example.sgbd.controller.dto.NovoPacienteRequest;
import com.example.sgbd.model.Paciente;
import com.example.sgbd.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> detalhar(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente alterar(Long id, NovoPacienteRequest novoPacienteRequest) {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);

        if(pacienteEncontrado.isEmpty()){
            return null;
        }

        Paciente paciente =  novoPacienteRequest.toModel();
        paciente.setId(pacienteEncontrado.get().getId());

        return salvar(paciente);
    }

    public boolean deletar(Long id) {

        Optional<Paciente> pacienteEncontrado = detalhar(id);

        if(pacienteEncontrado.isEmpty()){
            return false;
        }

        pacienteRepository.deleteById(id);
        return true;
    }
}
