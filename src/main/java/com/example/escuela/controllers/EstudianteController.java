package com.example.escuela.controllers;

import com.example.escuela.Excepciones.EmptyExeption;
import com.example.escuela.models.Estudiante;
import com.example.escuela.services.EstudianteServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class EstudianteController {


    @Autowired
    EstudianteServiceI estudianteService;

    @GetMapping("/estudiante")
    public List<Estudiante> obtenerEstudiantes(){

        return estudianteService.obtenerEstudiantes();
    }

    /*@PostMapping("/estudiante")
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){
        if(estudiante.getNombre() == null || estudiante.getNombre.isEmpty){
            throw new EmptyExeption("Nombre obligatorio", "err-32", HttpStatus.NOT_FOUND);
        }
        if(estudiante.getDireccion() == null || estudiante.getNombre.isEmpty){
            throw new EmptyExeption("Nombre obligatorio", "err-32", HttpStatus.NOT_FOUND);
        }


        Estudiante estudianteCreado = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }*/

    @PostMapping("/estudiante")
    public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new EmptyExeption("Nombre obligatorio", "err-32", HttpStatus.NOT_FOUND, bindingResult);
        }
        Estudiante estudianteCreado = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }
}
