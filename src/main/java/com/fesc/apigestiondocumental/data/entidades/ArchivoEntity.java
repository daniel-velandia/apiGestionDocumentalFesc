package com.fesc.apigestiondocumental.data.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity(name = "archivo")
public class ArchivoEntity implements Serializable {
    
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String idArchivo;

    @Lob
    @Column(name = "datos", columnDefinition = "MEDIUMBLOB", nullable = false)
    private byte[] datos;

    @OneToOne
    @JoinColumn(name = "id_info_archivo")
    private InfoArchivoEntity infoArchivoEntity;

    public static long getSerialversionuid() {
        return SerialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(String idArchivo) {
        this.idArchivo = idArchivo;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public InfoArchivoEntity getInfoArchivoEntity() {
        return infoArchivoEntity;
    }

    public void setInfoArchivoEntity(InfoArchivoEntity infoArchivoEntity) {
        this.infoArchivoEntity = infoArchivoEntity;
    }

    
}
