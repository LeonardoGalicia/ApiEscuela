package com.example.escuela;

import com.example.escuela.models.Estudiante;
import com.example.escuela.repositories.EstudianteRepository;
import com.example.escuela.services.EstudianteServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

public class EstudianteServiceTest {

    @Mock
    EstudianteRepository estudianteRepository;

    @InjectMocks
    EstudianteServiceImp estudianteService;

    Estudiante estudiante;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        estudiante = new Estudiante();
        estudiante.setIdEstudiante(1L);
        estudiante.setNombre("Leonardo");
    }

    @Test
    void testGetEstudianteById(){
        when(estudianteRepository.findById(1L)).thenReturn(Optional.ofNullable(estudiante));
        Estudiante estudianteActual = estudianteService.obtenerEstudianteById(1L);
        assertEquals(estudiante,estudianteActual);
    }

    @Test
    void testGetEstudiantes(){
        when(estudianteRepository.findAll()).thenReturn(List.of(estudiante,estudiante));
        List<Estudiante> listaEstudiantesActual = estudianteService.obtenerEstudiantes();
        assertEquals(2,listaEstudiantesActual.size());
    }

    @Test
    void testCreateEstudiante(){
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);
        Estudiante estudianteActual = estudianteService.crearEstudiante(estudiante);
        assertEquals(estudiante,estudianteActual);
    }

    @Test
    void testModifyEstudiante(){
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);
        when(estudianteRepository.findById(1L)).thenReturn(Optional.ofNullable(estudiante));
        estudiante.setNombre("Leo");
        Estudiante estudianteActualModificado = estudianteService.modificarEstudiante(1L, estudiante);
        assertEquals("Leo",estudianteActualModificado.getNombre());
    }

    @Test
    void testModifyEstudiante_whenEstudianteNotFound(){
        when(estudianteRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Estudiante estudianteActualModificado = estudianteService.modificarEstudiante(1L, estudiante);
        assertNull(estudianteActualModificado);
    }

    @Test
    void testDeleteEstudiante(){
        willDoNothing().given(estudianteRepository).deleteById(1L);

        estudianteService.eliminarEstudiante(1L);

        verify(estudianteRepository, times(1)).deleteById(1L);
    }
}
