package com.fesc.apigestiondocumental.models.respuestas;

public class EmpresaDetalleDataRestModel {
    
    private long id;
    private String idEmpresa;
    private String nomEmpresa;
    private String nit;
    private String correo;
    private String telefono;
    private String nombreAsistente;
    
    public EmpresaDetalleDataRestModel() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
