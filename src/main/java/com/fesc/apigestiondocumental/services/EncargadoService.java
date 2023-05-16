package com.fesc.apigestiondocumental.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.EncargadoEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEncargadoRepository;
import com.fesc.apigestiondocumental.shared.EncargadoDto;

@Service
public class EncargadoService implements IEncargadoService{
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEncargadoRepository iEncargadoRepository;

    @Override
    public EncargadoDto crearEncargado(EncargadoDto encargadoDto) {
        
        EncargadoEntity encargadoEntity = modelMapper.map(encargadoDto, EncargadoEntity.class);
        encargadoEntity.setIdEncargado(UUID.randomUUID().toString());

        EncargadoEntity encargadoEntityCreado = iEncargadoRepository.save(encargadoEntity);

        EncargadoDto encargadoDtoCreado = modelMapper.map(encargadoEntityCreado, EncargadoDto.class);

        return encargadoDtoCreado;
    }

}
