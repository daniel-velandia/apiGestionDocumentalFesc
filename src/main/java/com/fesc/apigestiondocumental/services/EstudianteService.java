package com.fesc.apigestiondocumental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEstudianteRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEstudianteRepository iEstudianteRepository;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

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

    @Override
    public List<InfoArchivoDto> obtenerArchivosEstudiante(String id) {
        
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(id);
        
        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByEstudianteEntityIdOrderByFechaDesc(estudianteEntity.getId());

        List<InfoArchivoDto> infoArchivoDtoList = new ArrayList<InfoArchivoDto>();

        for (InfoArchivoEntity infoArchivoEntity : infoArchivoEntityList) {
            
            InfoArchivoDto infoArchivoDto = modelMapper.map(infoArchivoEntity, InfoArchivoDto.class);

            infoArchivoDtoList.add(infoArchivoDto);
        }

        return infoArchivoDtoList;
    }
    
}
