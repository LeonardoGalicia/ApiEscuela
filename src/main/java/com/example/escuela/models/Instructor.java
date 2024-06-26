package com.example.escuela.models;


import jakarta.persistence.*;

@Entity
@Table(name = "instructores")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor")
    private Long idInstructor;
    @Column(name = "nombre_instructor")
    private String nombreInstructor;

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "idInstructor=" + idInstructor +
                ", nombreInstructor='" + nombreInstructor + '\'' +
                '}';
    }
}
