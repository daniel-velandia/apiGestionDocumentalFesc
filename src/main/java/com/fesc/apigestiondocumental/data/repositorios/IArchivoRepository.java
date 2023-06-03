package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesc.apigestiondocumental.data.entidades.ArchivoEntity;

public interface IArchivoRepository extends JpaRepository<ArchivoEntity, Long>{
    
    public ArchivoEntity findByIdArchivo(String idArchivo);

}
