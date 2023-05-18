package com.fesc.apigestiondocumental.models.respuestas;

public class EmpresaDataRestModel {
    
    private String nomEmpresa;
    private String nit;
    private String nombreAsistente;

    public EmpresaDataRestModel() {
    }
    
    public String getNomEmpresa() {
        return nomEmpresa;
    }
    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
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
