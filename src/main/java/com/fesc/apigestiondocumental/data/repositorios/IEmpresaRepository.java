package com.fesc.apigestiondocumental.data.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;


public interface IEmpresaRepository extends CrudRepository<EmpresaEntity, Long>{
    
    public EmpresaEntity findByIdEmpresa(String idEmpresa);
}
