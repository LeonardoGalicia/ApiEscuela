package com.example.escuela.services;

import com.example.escuela.models.Estudiante;
import com.example.escuela.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteServiceI{


    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> obtenerEstudiantes() {



        return estudianteRepository.findAll();

    }

    @Override
    public Estudiante obtenerEstudianteById(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante modificarEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteAModificar = estudianteRepository.findById(id).orElse(null);
        if (estudianteAModificar == null){
            return null;
        }
        estudianteAModificar.setNombre(estudiante.getNombre());
        return estudianteRepository.save(estudianteAModificar);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }


}
