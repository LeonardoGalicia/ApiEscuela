package com.example.escuela;

import com.example.escuela.models.Curso;
import com.example.escuela.models.Instructor;
import com.example.escuela.repositories.CursoRepository;

import com.example.escuela.services.CursoServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoServiceImp cursoService;

    Curso curso;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        curso = new Curso();
        curso.setIdCurso(1L);
        curso.setNombreCurso("POO");
        curso.setInstructor(new Instructor());

    }

    @Test
    void testGetCursoById(){
        when(cursoRepository.findById(1L)).thenReturn(Optional.ofNullable(curso));
        Curso cursoActual = cursoService.obtenerCurso(1L);
        assertEquals(curso,cursoActual);
    }

    @Test
    void testGetCursos(){
        when(cursoRepository.findAll()).thenReturn(List.of(curso,curso));
        List<Curso> cursosActuales = cursoService.obtenerCursos();
        assertEquals(2, cursosActuales.size());
    }




}
