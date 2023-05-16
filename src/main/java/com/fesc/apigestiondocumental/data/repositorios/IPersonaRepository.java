package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.PersonaEntity;

public interface IPersonaRepository extends CrudRepository<PersonaEntity, Long>{
    
}
