package com.fesc.apigestiondocumental.data.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;

public interface IInfoArchivoRepository extends CrudRepository<InfoArchivoEntity, Long>{
    
    public List<InfoArchivoEntity> getByEstudianteEntityIdOrderByFechaDesc(long estudianteEntityId);
    
    public List<InfoArchivoEntity> getByEmpresaEntityIdOrderByFechaDesc(long empresaEntityId);
}
