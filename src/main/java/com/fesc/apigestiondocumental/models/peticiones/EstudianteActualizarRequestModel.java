package com.fesc.apigestiondocumental.models.peticiones;

public class EstudianteActualizarRequestModel extends PersonaActualizarRequestModel{
    
    private String carrera;
    private String semestre;

    public EstudianteActualizarRequestModel() {
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
