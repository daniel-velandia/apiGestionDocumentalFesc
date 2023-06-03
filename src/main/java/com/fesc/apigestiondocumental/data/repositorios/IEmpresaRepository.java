package com.fesc.apigestiondocumental.data.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;


public interface IEmpresaRepository extends CrudRepository<EmpresaEntity, Long>{

    public EmpresaEntity findByIdEmpresa(String idEmpresa);

    public EmpresaEntity findByNomEmpresa(String nomEmpresa);

    public List<EmpresaEntity> getByUsuarioEntityUsernameOrderByCreadoDesc(String username);

    public EmpresaEntity findByNit(String nit);
}
