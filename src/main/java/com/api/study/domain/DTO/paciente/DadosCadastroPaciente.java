package com.api.study.domain.DTO.paciente;

import com.api.study.domain.DTO.DadosEndereco;
import com.api.study.domain.DTO.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank @CPF
        String documento,
        @NotBlank
        String telefone,
        @NotNull
        Especialidade especialidadeProcurada,
        @NotNull @Valid
        DadosEndereco endereco){
}
