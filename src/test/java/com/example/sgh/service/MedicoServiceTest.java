package com.example.sgh.service;

import com.example.sgh.ApplicationConfigTest;
import com.example.sgh.controller.dto.NovoMedicoRequest;
import com.example.sgh.model.Medico;
import com.example.sgh.repository.MedicoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DisplayName("MedicoServiceTest")
class MedicoServiceTest extends ApplicationConfigTest {

    @MockBean
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoService medicoService;

    private Long idMedico = 1L;
    private NovoMedicoRequest novoMedicoRequest = new NovoMedicoRequest(
            "Strange",
            "Cirurgião",
            "36267116336",
            "(34) 98888-8888",
            "drstrange@gmail.com",
            "00000000-0/BR",
            "123mudar"
    );
    private Medico dadosMedicosAtuais = new Medico(
            "Stephen",
            "Cirurgião",
            "36267116336",
            "(34) 91234-5678",
            "drstrange@gmail.com",
            "00000000-0/BR",
            "123mudar"
    );

    @Test
    @DisplayName("Deve alterar dados do medico quando id do medico valido")
    public void deveAlterarDadosDoMedicoQuandoIdDoMedicoValido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.eq(idMedico))).thenReturn(Optional.of(dadosMedicosAtuais));
        Mockito.when(medicoRepository.save(ArgumentMatchers.any())).thenReturn(novoMedicoRequest.toModel());

        //When
        Medico medicoAlterado = medicoService.alterarMedico(idMedico, novoMedicoRequest);

        //Then
        Assertions.assertEquals("Strange", medicoAlterado.getNomeMedico());
        Assertions.assertEquals("(34) 98888-8888", medicoAlterado.getTelefoneMedico());
    }

    @Test
    @DisplayName("Deve retornar null quando id do medico invalido")
    public void deveRetornarNullQuandoIdMedicoInvalido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());

        //When
        Medico medicoAlterado = medicoService.alterarMedico(idMedico, novoMedicoRequest);

        //Then
        Assertions.assertEquals(null, medicoAlterado);
    }

    @Test
    @DisplayName("Deve deletar dados do medico quando id valido")
    public void deveDeletarDadosDoMedicoQuandoIdValido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.eq(idMedico))).thenReturn(Optional.of(dadosMedicosAtuais));

        //When
        boolean deletarMedicoResposta = medicoService.deletarMedico(idMedico);

        //Then
        Assertions.assertEquals(true, deletarMedicoResposta);
    }

    @Test
    @DisplayName("Deve retornar false quando id invalido")
    public void deveRetornarFalseQuandoIdInvalido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.eq(idMedico))).thenReturn(Optional.empty());

        //When
        boolean deletarMedicoResposta = medicoService.deletarMedico(idMedico);

        //Then
        Assertions.assertEquals(false, deletarMedicoResposta);
    }

    @Test
    @DisplayName("Deve retornar medico quando id valido")
    public void deveRetornarMedicoQuandoIdValido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.eq(idMedico))).thenReturn(Optional.of(dadosMedicosAtuais));

        //When
        Optional<Medico> detalharMedicoResposta = medicoService.detalharMedico(idMedico);

        //Then
        Assertions.assertEquals(dadosMedicosAtuais, detalharMedicoResposta.get());
    }

    @Test
    @DisplayName("Deve retornar empty quando id invalido")
    public void deveRetornarEmptyQuandoIdInvalido() {
        //Given
        Mockito.when(medicoRepository.findById(ArgumentMatchers.eq(idMedico))).thenReturn(Optional.empty());

        //When
        Optional<Medico> detalharMedicoResposta = medicoService.detalharMedico(idMedico);

        //Then
        Assertions.assertTrue(detalharMedicoResposta.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar lista de todos os medicos")
    public void deveRetornarListaDeTodosOsMedicos() {
        //Given
        Mockito.when(medicoRepository.findAll()).thenReturn(new ArrayList(Arrays.asList(dadosMedicosAtuais)));

        //When
        List<Medico> listarTodosMedicosResposta = medicoService.listarTodosMedicos();

        //Then
        Assertions.assertEquals(new ArrayList(Arrays.asList(dadosMedicosAtuais)), listarTodosMedicosResposta);
    }

    @Test
    @DisplayName("Deve retornar lista vazia de medicos")
    public void deveRetornarListaVaziaDeMedicos() {
        //Given
        Mockito.when(medicoRepository.findAll()).thenReturn(new ArrayList());

        //When
        List<Medico> listarTodosMedicosResposta = medicoService.listarTodosMedicos();

        //Then
        Assertions.assertEquals(new ArrayList(), listarTodosMedicosResposta);
    }

}