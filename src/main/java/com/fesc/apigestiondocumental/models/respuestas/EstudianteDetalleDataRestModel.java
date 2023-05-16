package com.fesc.apigestiondocumental.models.respuestas;

public class EstudianteDetalleDataRestModel extends PersonaDataRestModel{
    
    private String idEstudiante;
    private String carrera;
    private String semestre;
    
    public EstudianteDetalleDataRestModel() {
    }

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
