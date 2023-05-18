package com.fesc.apigestiondocumental.data.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "encargado")
public class EncargadoEntity extends PersonaEntity{
    
    @Column(nullable = false)
    private String idEncargado;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String area;

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}
