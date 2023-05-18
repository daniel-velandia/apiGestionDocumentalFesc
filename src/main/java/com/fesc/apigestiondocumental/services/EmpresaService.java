package com.fesc.apigestiondocumental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEmpresaRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

    @Override
    public EmpresaDto crearEmpresa(EmpresaDto empresaDto) {
        
        EmpresaEntity empresaEntity = modelMapper.map(empresaDto, EmpresaEntity.class);
        empresaEntity.setIdEmpresa(UUID.randomUUID().toString());

        EmpresaEntity empresaEntityCreado = iEmpresaRepository.save(empresaEntity);

        EmpresaDto empresaDtoCreado = modelMapper.map(empresaEntityCreado, EmpresaDto.class);

        return empresaDtoCreado;
    }

    @Override
    public EmpresaDto detalleEmpresa(String id) {
        
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(id);

        EmpresaDto empresaDto = modelMapper.map(empresaEntity, EmpresaDto.class);

        return empresaDto;
    }

    @Override
    public List<InfoArchivoDto> obtenerArchivosEmpresa(String id) {

        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(id);
        
        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByEmpresaEntityIdOrderByFechaDesc(empresaEntity.getId());

        List<InfoArchivoDto> infoArchivoDtoList = new ArrayList<InfoArchivoDto>();

        for (InfoArchivoEntity infoArchivoEntity : infoArchivoEntityList) {
            
            InfoArchivoDto infoArchivoDto = modelMapper.map(infoArchivoEntity, InfoArchivoDto.class);

            infoArchivoDtoList.add(infoArchivoDto);
        }

        return infoArchivoDtoList;
    }
    
}
