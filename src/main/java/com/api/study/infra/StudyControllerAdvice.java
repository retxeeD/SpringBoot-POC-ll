package com.api.study.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class StudyControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(EntityNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErrorValidacao::new).toList());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarErro422(SQLIntegrityConstraintViolationException ex){
        var error = ex.getMessage();
        return ResponseEntity.unprocessableEntity().body(error);
    }

    private record DadosErrorValidacao(String campo, String mensagem){
        public DadosErrorValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
