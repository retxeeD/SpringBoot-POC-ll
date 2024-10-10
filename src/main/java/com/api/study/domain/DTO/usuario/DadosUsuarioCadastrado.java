package com.api.study.domain.DTO.usuario;

import com.api.study.domain.entity.Usuario;

public record DadosUsuarioCadastrado (Long id, String email, String senha){
    public DadosUsuarioCadastrado(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getSenha());
    }
}
