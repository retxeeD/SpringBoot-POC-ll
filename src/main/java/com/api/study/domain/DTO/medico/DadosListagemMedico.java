package com.api.study.domain.DTO.medico;

import com.api.study.domain.DTO.Especialidade;
import com.api.study.domain.entity.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String CRM, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
