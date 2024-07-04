package com.example.escuela.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity()
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @NotNull(message = "Nombre nulo")
    @NotEmpty(message = "Nombre Vacio")
    private String nombre;


    /*@NotNull(message = "Direccion nula")
    @Size(min = 3, max = 5)
    private String direccion;


    @Email(message = "Direccion invalida")
    private String mail;*/



    public Estudiante() {

    }

    public Estudiante(Long idEstudiante, String nombre, String direccion, String mail) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        /*this.direccion = direccion;
        this.mail = mail;*/
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
