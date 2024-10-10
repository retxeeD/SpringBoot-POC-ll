package com.api.study.domain.DTO.paciente;

import com.api.study.domain.DTO.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente (
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){
}
