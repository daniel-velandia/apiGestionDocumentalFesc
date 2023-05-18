package com.fesc.apigestiondocumental.shared;

public class EncargadoDto extends PersonaDto{
    
    private String idEncargado;
    private String cargo;
    private String area;
    
    public EncargadoDto() {
    }

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
