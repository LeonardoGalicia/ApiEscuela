package com.example.escuela.services;

import com.example.escuela.models.Curso;


import java.util.List;

public interface CursoServiceI {
    List<Curso> obtenerCursos();
    Curso obtenerCurso(Long id);
}
