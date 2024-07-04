package com.example.escuela.services;

import com.example.escuela.models.Estudiante;

import java.util.List;

public interface EstudianteServiceI {
     List<Estudiante> obtenerEstudiantes();

     Estudiante obtenerEstudianteById(Long id);
     Estudiante crearEstudiante(Estudiante estudiante);

     Estudiante modificarEstudiante(Long id, Estudiante estudiante);

     void eliminarEstudiante(Long id);


}
