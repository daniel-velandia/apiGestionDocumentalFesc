package com.fesc.apigestiondocumental.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

public class MapperArchivo {

    @Autowired
    ModelMapper modelMapper;

    // creé esta clase porque tuve problemas al configurar modelMapper para que no me incluyera en el mapeo el archivo
    public InfoArchivoDto mapDto(InfoArchivoEntity infoArchivoEntity) {

        InfoArchivoDto infoArchivoDto = new InfoArchivoDto();

        // Mapeo de las propiedades directas
        BeanUtils.copyProperties(infoArchivoEntity, infoArchivoDto);

        // Mapeo de las propiedades anidadas usando ModelMapper
        if(infoArchivoEntity.getEstudianteEntity() != null) {
            infoArchivoDto.setEstudianteEntity(modelMapper.map(infoArchivoEntity.getEstudianteEntity(), EstudianteDto.class));
        } else {
            infoArchivoDto.setEmpresaEntity(modelMapper.map(infoArchivoEntity.getEmpresaEntity(), EmpresaDto.class));
        }
        
        infoArchivoDto.setEncargadoEntity(modelMapper.map(infoArchivoEntity.getEncargadoEntity(), EncargadoDto.class));
        infoArchivoDto.setUsuarioEntity(modelMapper.map(infoArchivoEntity.getUsuarioEntity(), UsuarioDto.class));

        if (!infoArchivoEntity.isTipoRadicado()) {
            InfoArchivoDto infoArchivoDtoRespuesta = new InfoArchivoDto();

            // Mapeo de las propiedades de respuesta anidadas usando ModelMapper
            if(infoArchivoEntity.getRespuestaEntity().getEstudianteEntity() != null) {
                infoArchivoDtoRespuesta.setEstudianteEntity(modelMapper.map(infoArchivoEntity.getRespuestaEntity().getEstudianteEntity(), EstudianteDto.class));
            } else {
                infoArchivoDtoRespuesta.setEmpresaEntity(modelMapper.map(infoArchivoEntity.getRespuestaEntity().getEmpresaEntity(), EmpresaDto.class));
            }

            BeanUtils.copyProperties(infoArchivoEntity.getRespuestaEntity(), infoArchivoDtoRespuesta);
            infoArchivoDtoRespuesta.setEncargadoEntity(modelMapper.map(infoArchivoEntity.getRespuestaEntity().getEncargadoEntity(), EncargadoDto.class));
            infoArchivoDtoRespuesta.setUsuarioEntity(modelMapper.map(infoArchivoEntity.getRespuestaEntity().getUsuarioEntity(), UsuarioDto.class));

            infoArchivoDto.setRespuestaEntity(infoArchivoDtoRespuesta);
        }

        return infoArchivoDto;
    }
}
