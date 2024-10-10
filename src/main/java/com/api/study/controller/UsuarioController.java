package com.api.study.controller;

import com.api.study.domain.DTO.usuario.DadosCadastroUsuario;
import com.api.study.domain.DTO.usuario.DadosUsuarioCadastrado;
import com.api.study.domain.entity.Usuario;
import com.api.study.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosUsuarioCadastrado> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
        var senhaBcrypt = encoder.encode(dados.senha());
        var usuario = new Usuario(dados.email(), senhaBcrypt);
        repository.save(usuario);

        return ResponseEntity.ok(new DadosUsuarioCadastrado(usuario));
    }

}
