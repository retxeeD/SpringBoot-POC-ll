package com.api.study.domain.DTO.medico;

import com.api.study.domain.DTO.Especialidade;
import com.api.study.domain.entity.Endereco;
import com.api.study.domain.entity.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone,Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
