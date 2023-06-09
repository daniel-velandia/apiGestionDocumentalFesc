package com.fesc.apigestiondocumental.shared;

import java.io.Serializable;
import java.time.LocalDate;

public class InfoArchivoDto implements Serializable{

    private static final long SerialVersionUID = 1L;

    private long id;
    private String idInfoArchivo;
    private String nombre;
    private String peso;
    private LocalDate creado; 
    private String numRadicado;
    private boolean tipoRadicado;
    private String tipoDocumento;
    private String asunto;
    private String anexos;
    private boolean reqRespuesta;
    private boolean informarEncargado;
    private String estudiante;
    private String empresa;
    private String encargado;
    private String entrega;
    private String username; 
    private EstudianteDto estudianteEntity;
    private EmpresaDto empresaEntity;
    private EncargadoDto encargadoEntity;
    private InfoArchivoDto entregaEntity;
    private UsuarioDto usuarioEntity;
    private ArchivoDto archivoEntity;
    
    public InfoArchivoDto() {
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

    public String getIdInfoArchivo() {
        return idInfoArchivo;
    }

    public void setIdInfoArchivo(String idInfoArchivo) {
        this.idInfoArchivo = idInfoArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public String getNumRadicado() {
        return numRadicado;
    }

    public void setNumRadicado(String numRadicado) {
        this.numRadicado = numRadicado;
    }

    public boolean isTipoRadicado() {
        return tipoRadicado;
    }

    public void setTipoRadicado(boolean tipoRadicado) {
        this.tipoRadicado = tipoRadicado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public boolean isReqRespuesta() {
        return reqRespuesta;
    }

    public void setReqRespuesta(boolean reqRespuesta) {
        this.reqRespuesta = reqRespuesta;
    }

    public boolean isInformarEncargado() {
        return informarEncargado;
    }

    public void setInformarEncargado(boolean informarEncargado) {
        this.informarEncargado = informarEncargado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EstudianteDto getEstudianteEntity() {
        return estudianteEntity;
    }

    public void setEstudianteEntity(EstudianteDto estudianteEntity) {
        this.estudianteEntity = estudianteEntity;
    }

    public EmpresaDto getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaDto empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public EncargadoDto getEncargadoEntity() {
        return encargadoEntity;
    }

    public void setEncargadoEntity(EncargadoDto encargadoEntity) {
        this.encargadoEntity = encargadoEntity;
    }

    public InfoArchivoDto getEntregaEntity() {
        return entregaEntity;
    }

    public void setEntregaEntity(InfoArchivoDto entregaEntity) {
        this.entregaEntity = entregaEntity;
    }

    public UsuarioDto getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDto usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public ArchivoDto getArchivoEntity() {
        return archivoEntity;
    }

    public void setArchivoEntity(ArchivoDto archivoEntity) {
        this.archivoEntity = archivoEntity;
    }

    
}
