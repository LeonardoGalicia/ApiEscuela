package com.example.escuela.services;

import com.example.escuela.models.Curso;
import com.example.escuela.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImp implements CursoServiceI{

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }


}
