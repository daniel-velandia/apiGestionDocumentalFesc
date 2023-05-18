package com.fesc.apigestiondocumental.models.respuestas;

import java.util.Date;

public class InfoArchivoDataRestModel {
    
    private long id;
    private String idInfoArchivo;
    private String nombre;
    private String peso;
    private Date fecha;
    private String numRadicado;
    private boolean tipoRadicado;
    private String tipoDocumento;
    private String asunto;
    private String anexos;
    private boolean respuesta;
    private EstudianteDataRestModel estudianteEntity;
    private EmpresaDataRestModel empresaEntity;
    private EncargadoDataRestModel encargadoEntity;
    private InfoArchivoDataRestModel respuestaEntity;
    private UsuarioDataRestModel usuarioEntity;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
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

    public InfoArchivoDataRestModel getRespuestaEntity() {
        return respuestaEntity;
    }

    public void setRespuestaEntity(InfoArchivoDataRestModel respuestaEntity) {
        this.respuestaEntity = respuestaEntity;
    }

    public UsuarioDataRestModel getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDataRestModel usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    
}
