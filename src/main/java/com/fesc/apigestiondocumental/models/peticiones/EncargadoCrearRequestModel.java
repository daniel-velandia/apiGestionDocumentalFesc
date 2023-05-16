package com.fesc.apigestiondocumental.models.peticiones;

public class EncargadoCrearRequestModel extends PersonaRequestModel{
    
    private String cargo;
    private String area;
    
    public EncargadoCrearRequestModel() {
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
