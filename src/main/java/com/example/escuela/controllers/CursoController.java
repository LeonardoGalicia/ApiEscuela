package com.example.escuela.controllers;

import com.example.escuela.Excepciones.NotFoundExeption;
import com.example.escuela.models.Curso;
import com.example.escuela.services.CursoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class CursoController {

    @Autowired
    CursoServiceI cursoServiceI;

    @GetMapping("/curso")
    public List<Curso> obtenerCursos(){
        return cursoServiceI.obtenerCursos();
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> obteberCurso(@PathVariable Long id) {
        Curso curso;
        curso = cursoServiceI.obtenerCurso(id);
        if(curso == null){
           throw new NotFoundExeption("Curso no encontrado", "err-12", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(curso);
    }


}
