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
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}
