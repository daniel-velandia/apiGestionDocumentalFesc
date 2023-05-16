package com.fesc.apigestiondocumental.models.respuestas;

public class UsuarioDataRestModel {
    
    private String username;

    public UsuarioDataRestModel() {
    }

    public UsuarioDataRestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
