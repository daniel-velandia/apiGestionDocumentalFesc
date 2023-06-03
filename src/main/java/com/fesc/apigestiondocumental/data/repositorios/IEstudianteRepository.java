package com.fesc.apigestiondocumental.data.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;


public interface IEstudianteRepository extends CrudRepository<EstudianteEntity, Long>{
    
    public EstudianteEntity findByIdEstudiante(String idEstudiante);

    public EstudianteEntity findByDocumento(String documento);

    public EstudianteEntity findByNombre(String nombre);

    public EstudianteEntity findByCorreo(String correo);

    public List<EstudianteEntity> getByUsuarioEntityUsernameOrderByCreadoDesc(String username);
}
