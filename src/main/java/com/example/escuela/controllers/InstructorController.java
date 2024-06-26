package com.example.escuela.controllers;


import com.example.escuela.models.Instructor;
import com.example.escuela.services.InstructorServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class InstructorController {


    @Autowired
    InstructorServiceI instructorServiceI;



    @GetMapping("/instructor")
    public List<Instructor> obtenerInstructores(){
        return instructorServiceI.obtenerInstructores();
    }
}
