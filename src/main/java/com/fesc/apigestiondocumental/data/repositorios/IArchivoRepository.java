package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.ArchivoEntity;

public interface IArchivoRepository extends CrudRepository<ArchivoEntity, Long>{
    
    public ArchivoEntity findByIdArchivo(String idArchivo);

}
