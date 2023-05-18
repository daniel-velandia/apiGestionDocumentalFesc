package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;

public interface IInfoArchivoRepository extends CrudRepository<InfoArchivoEntity, Long>{
    
}
