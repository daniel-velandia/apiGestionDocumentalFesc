package com.fesc.apigestiondocumental.models.respuestas;

public class ArchivoDataRestModel {
    
    private String idArchivo;
    private byte[] datos;
    private InfoArchivoDataRestModel infoArchivoEntity;

    public ArchivoDataRestModel() {
    }

    public String getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(String idArchivo) {
        this.idArchivo = idArchivo;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public InfoArchivoDataRestModel getInfoArchivoEntity() {
        return infoArchivoEntity;
    }

    public void setInfoArchivoEntity(InfoArchivoDataRestModel infoArchivoEntity) {
        this.infoArchivoEntity = infoArchivoEntity;
    }

    
}
