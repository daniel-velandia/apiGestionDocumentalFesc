package com.fesc.apigestiondocumental.shared;

import java.io.Serializable;

public class EmpresaDto implements Serializable{

    private static final long SerialVersionUID = 1L;
    
    private long id;
    private String idEmpresa;
    private String nombreEmpresa;
    private String nit;
    private String correo;
    private String telefono;
    private String nombreAsistente;

    public EmpresaDto() {
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
    public String getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
