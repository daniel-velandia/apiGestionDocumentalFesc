package com.fesc.apigestiondocumental.data.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "estudiante")
public class EstudianteEntity extends PersonaEntity{

    
    @Column(nullable = false)
    private String idEstudiante;

    @Column(nullable = false)
    private String carrera;

    @Column(nullable = false)
    private String semestre;

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    
}
