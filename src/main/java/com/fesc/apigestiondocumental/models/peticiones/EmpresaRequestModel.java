package com.fesc.apigestiondocumental.models.peticiones;

public class EmpresaRequestModel {

    private String nomEmpresa;
    private String nit;
    private String correo;
    private String telefono;
    private String nombreAsistente;
    
    public EmpresaRequestModel() {
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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombreAsistente() {
        return nombreAsistente;
    }
    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    
}
