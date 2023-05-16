package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;

public interface IEstudianteRepository extends CrudRepository<EstudianteEntity, Long>{
    
    public EstudianteEntity findByIdEstudiante(String id);
}
