package com.example.escuela.services;

import com.example.escuela.models.Instructor;
import com.example.escuela.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorServiceI{

    @Autowired
    InstructorRepository instructorRepository;


    @Override
    public List<Instructor> obtenerInstructores() {
        return instructorRepository.findAll();
    }
}
