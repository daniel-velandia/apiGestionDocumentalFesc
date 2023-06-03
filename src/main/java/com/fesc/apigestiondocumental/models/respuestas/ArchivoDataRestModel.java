package com.fesc.apigestiondocumental.models.respuestas;

public class ArchivoDataRestModel {
    
    private long id;
    private String idArchivo;
    private byte[] datos;

    public ArchivoDataRestModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    
}
