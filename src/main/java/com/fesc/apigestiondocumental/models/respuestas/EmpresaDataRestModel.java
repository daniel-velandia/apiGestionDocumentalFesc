package com.fesc.apigestiondocumental.models.respuestas;

public class EmpresaDataRestModel {
    
    private String nombreEmpresa;
    private String nit;
    private String nombreAsistente;

    public EmpresaDataRestModel() {
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getNombreAsistente() {
        return nombreAsistente;
    }
    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    
}
