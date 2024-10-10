package com.api.study.domain.DTO.paciente;

import com.api.study.domain.DTO.Especialidade;
import com.api.study.domain.entity.Endereco;
import com.api.study.domain.entity.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String documento, String telefone, Especialidade especialidadeProcurada, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefone(), paciente.getEspecialidadeProcurada(), paciente.getEndereco());
    }
}
