package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
    
}
