package com.fesc.apigestiondocumental.data.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.EncargadoEntity;


public interface IEncargadoRepository extends CrudRepository<EncargadoEntity, Long>{

    public EncargadoEntity findByIdEncargado(String idEncargado);

    public EncargadoEntity findByDocumento(String documento);

    public EncargadoEntity findByCorreo(String correo);

    public List<EncargadoEntity> getByUsuarioEntityUsernameOrderByCreadoDesc(String username);
}
