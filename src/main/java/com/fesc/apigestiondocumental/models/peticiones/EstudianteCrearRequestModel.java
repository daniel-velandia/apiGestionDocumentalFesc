package com.fesc.apigestiondocumental.models.peticiones;

public class EstudianteCrearRequestModel extends PersonaRequestModel{
    
    private String carrera;
    private String semestre;

    public EstudianteCrearRequestModel() {
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
