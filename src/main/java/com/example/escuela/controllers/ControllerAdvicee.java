package com.example.escuela.controllers;

import com.example.escuela.Excepciones.EmptyExeption;
import com.example.escuela.Excepciones.NotFoundExeption;
import com.example.escuela.utils.ModelError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvicee {

    @ExceptionHandler(value = EmptyExeption.class)
    public ResponseEntity<ModelError> validacionVacios(EmptyExeption emptyExeption){
        List<String> errores = emptyExeption.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()); //API DE STREAM

        ModelError modelError = new ModelError(emptyExeption.getCodigo(), emptyExeption.getMessage(),errores);

        return new ResponseEntity<>(modelError, emptyExeption.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoundExeption.class)
    public ResponseEntity<ModelError> elementoNoEncontrado(NotFoundExeption notFoundExeption){
        ModelError modelError = new ModelError(notFoundExeption.getCodigo(), notFoundExeption.getMessage(),null);

        return new ResponseEntity<>(modelError, notFoundExeption.getHttpStatus());
    }
}
