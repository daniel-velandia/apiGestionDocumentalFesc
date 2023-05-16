package com.fesc.apigestiondocumental.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEstudianteRepository;
import com.fesc.apigestiondocumental.shared.EstudianteDto;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEstudianteRepository iEstudianteRepository;

    @Override
    public EstudianteDto crearEstudiante(EstudianteDto estudianteDto) {
        
        EstudianteEntity estudianteEntity = modelMapper.map(estudianteDto, EstudianteEntity.class);
        estudianteEntity.setIdEstudiante(UUID.randomUUID().toString());

        EstudianteEntity estudianteEntityCreado = iEstudianteRepository.save(estudianteEntity);

        EstudianteDto estudianteDtoCreado = modelMapper.map(estudianteEntityCreado, EstudianteDto.class);

        return estudianteDtoCreado;
    }

    @Override
    public EstudianteDto detalleEstudiante(String id) {
        
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(id);

        EstudianteDto estudianteDto = modelMapper.map(estudianteEntity, EstudianteDto.class);

        return estudianteDto;
    }
    
}
