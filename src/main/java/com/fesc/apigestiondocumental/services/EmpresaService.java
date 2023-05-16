package com.fesc.apigestiondocumental.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEmpresaRepository;
import com.fesc.apigestiondocumental.shared.EmpresaDto;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Override
    public EmpresaDto crearEmpresa(EmpresaDto empresaDto) {
        
        EmpresaEntity empresaEntity = modelMapper.map(empresaDto, EmpresaEntity.class);
        empresaEntity.setIdEmpresa(UUID.randomUUID().toString());

        EmpresaEntity empresaEntityCreado = iEmpresaRepository.save(empresaEntity);

        EmpresaDto empresaDtoCreado = modelMapper.map(empresaEntityCreado, EmpresaDto.class);

        return empresaDtoCreado;
    }
    
}
