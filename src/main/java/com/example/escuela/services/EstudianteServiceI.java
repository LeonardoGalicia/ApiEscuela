package com.example.escuela.services;

import com.example.escuela.models.Estudiante;

import java.util.List;

public interface EstudianteServiceI {
     List<Estudiante> obtenerEstudiantes();
     Estudiante crearEstudiante(Estudiante estudiante);

}
