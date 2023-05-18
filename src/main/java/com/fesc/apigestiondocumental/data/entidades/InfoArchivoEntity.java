package com.fesc.apigestiondocumental.data.entidades;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "infoArchivo")
@EntityListeners(AuditingEntityListener.class)
public class InfoArchivoEntity implements Serializable {
    
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idInfoArchivo;
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String peso;
    
    @CreatedDate
    private Date fecha;
    
    @Column(nullable = false)
    private String numRadicado;
    
    @Column(nullable = false)
    private boolean tipoRadicado;
    
    @Column(nullable = false)
    private String tipoDocumento;
    
    @Column(nullable = false)
    private String asunto;

    @Column(nullable = true)
    private String anexos;
    
    @Column(nullable = false)
    private boolean reqRespuesta;
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private EstudianteEntity estudianteEntity;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresaEntity;
    
    @ManyToOne
    @JoinColumn(name = "id_encargado")
    private EncargadoEntity encargadoEntity;
    
    @OneToOne
    @JoinColumn(name = "id_respuesta")
    private InfoArchivoEntity respuestaEntity;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;

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

    public EstudianteEntity getEstudianteEntity() {
        return estudianteEntity;
    }

    public void setEstudianteEntity(EstudianteEntity estudianteEntity) {
        this.estudianteEntity = estudianteEntity;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public EncargadoEntity getEncargadoEntity() {
        return encargadoEntity;
    }

    public void setEncargadoEntity(EncargadoEntity encargadoEntity) {
        this.encargadoEntity = encargadoEntity;
    }

    public InfoArchivoEntity getRespuestaEntity() {
        return respuestaEntity;
    }

    public void setRespuestaEntity(InfoArchivoEntity respuestaEntity) {
        this.respuestaEntity = respuestaEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    
}
