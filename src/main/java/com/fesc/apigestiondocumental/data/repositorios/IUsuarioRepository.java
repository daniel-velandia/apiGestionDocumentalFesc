package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
    
    public UsuarioEntity findByUsername(String username);

    public UsuarioEntity findByCorreo(String correo);

    public UsuarioEntity findByDocumento(String documento);

    public UsuarioEntity findById(long id);
}
