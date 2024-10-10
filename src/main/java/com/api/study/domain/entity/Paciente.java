package com.api.study.domain.entity;

import com.api.study.domain.DTO.paciente.DadosAtualizacaoPaciente;
import com.api.study.domain.DTO.paciente.DadosCadastroPaciente;
import com.api.study.domain.DTO.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidadeProcurada;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente paciente){
        this.ativo = true;
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.documento = paciente.documento();
        this.telefone = paciente.telefone();
        this.especialidadeProcurada = paciente.especialidadeProcurada();
        this.endereco = new Endereco(paciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
