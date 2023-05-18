package com.fesc.apigestiondocumental.shared;

import java.io.Serializable;
import java.util.Date;

public class InfoArchivoDto implements Serializable{
    
    private static final long SerialVersionUID = 1L;

    private long id;
    private String idInfoArchivo;
    private String nombre;
    private Date fecha;
    private String numRadicado;
    private boolean tipoRadicado;
    private String tipoDocumento;
    private String asunto;
    private String anexos;
    private boolean reqRespuesta;
    private EstudianteDto estudianteEntity;
    private EmpresaDto empresaEntity;
    private EncargadoDto encargadoEntity;
    private InfoArchivoDto respuestaEntity;
    private UsuarioDto usuarioEntity;
    
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

    public boolean isReqRespuesta() {
        return reqRespuesta;
    }

    public void setReqRespuesta(boolean reqRespuesta) {
        this.reqRespuesta = reqRespuesta;
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

    public InfoArchivoDto getRespuestaEntity() {
        return respuestaEntity;
    }

    public void setRespuestaEntity(InfoArchivoDto respuestaEntity) {
        this.respuestaEntity = respuestaEntity;
    }

    public UsuarioDto getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDto usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    
}
