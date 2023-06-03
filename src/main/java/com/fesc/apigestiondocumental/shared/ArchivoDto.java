package com.fesc.apigestiondocumental.shared;

import java.io.Serializable;

public class ArchivoDto implements Serializable{
    
    private static final long SerialVersionUID = 1L;

    private long id;
    private String idArchivo;
    private byte[] datos;

    public ArchivoDto() {
    }

    public static long getSerialversionuid() {
        return SerialVersionUID;
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
