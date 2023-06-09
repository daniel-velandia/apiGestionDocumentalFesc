package com.fesc.apigestiondocumental.models.respuestas;

import java.time.LocalDate;

public class InfoArchivoDataRestModel {
    
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
    private String entrega;
    private EstudianteDataRestModel estudianteEntity;
    private EmpresaDataRestModel empresaEntity;
    private EncargadoDataRestModel encargadoEntity;
    private InfoArchivoDataRestModel entregaEntity;
    private UsuarioDataRestModel usuarioEntity;
    private ArchivoDataRestModel archivoEntity;

    public InfoArchivoDataRestModel() {
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

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public EstudianteDataRestModel getEstudianteEntity() {
        return estudianteEntity;
    }

    public void setEstudianteEntity(EstudianteDataRestModel estudianteEntity) {
        this.estudianteEntity = estudianteEntity;
    }

    public EmpresaDataRestModel getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaDataRestModel empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public EncargadoDataRestModel getEncargadoEntity() {
        return encargadoEntity;
    }

    public void setEncargadoEntity(EncargadoDataRestModel encargadoEntity) {
        this.encargadoEntity = encargadoEntity;
    }

    public InfoArchivoDataRestModel getEntregaEntity() {
        return entregaEntity;
    }

    public void setEntregaEntity(InfoArchivoDataRestModel entregaEntity) {
        this.entregaEntity = entregaEntity;
    }

    public UsuarioDataRestModel getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDataRestModel usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public ArchivoDataRestModel getArchivoEntity() {
        return archivoEntity;
    }

    public void setArchivoEntity(ArchivoDataRestModel archivoEntity) {
        this.archivoEntity = archivoEntity;
    }

    
}
