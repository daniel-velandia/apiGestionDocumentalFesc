package com.fesc.apigestiondocumental.models.peticiones;

public class UsuarioActualizarRequestModel {
    
    private String documento;
    private String username;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;
    private String password;
    private String passwordApp;
    
    public UsuarioActualizarRequestModel() {
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordApp() {
        return passwordApp;
    }
    public void setPasswordApp(String passwordApp) {
        this.passwordApp = passwordApp;
    }

    
}
