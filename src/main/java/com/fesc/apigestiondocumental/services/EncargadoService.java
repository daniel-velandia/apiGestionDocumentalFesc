package com.fesc.apigestiondocumental.services;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.data.entidades.EncargadoEntity;
import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEncargadoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.utils.Validaciones;

@Service
public class EncargadoService implements IEncargadoService{
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEncargadoRepository iEncargadoRepository;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    Validaciones validaciones;

    @Override
    public RespuestaDto crearEncargado(EncargadoDto encargadoDto) {

        validaciones.validarCamposEncargado(encargadoDto);

        if(iEncargadoRepository.findByCorreo(encargadoDto.getCorreo()) != null) {
            throw new ErrorException("correo ya existe");
        }

        if(iEncargadoRepository.findByDocumento(encargadoDto.getDocumento()) != null) {
            throw new ErrorException("documento ya existe");
        }

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(encargadoDto.getUsername());
        
        EncargadoEntity encargadoEntity = modelMapper.map(encargadoDto, EncargadoEntity.class);
        encargadoEntity.setIdEncargado(UUID.randomUUID().toString());
        encargadoEntity.setUsuarioEntity(usuarioEntity);
        
        iEncargadoRepository.save(encargadoEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public EncargadoDto leerEncargado(String username, String id) {
        
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(id);

        if(!encargadoEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        EncargadoDto encargadoDto = modelMapper.map(encargadoEntity, EncargadoDto.class);

        return encargadoDto;
    }

    @Override
    public RespuestaDto actualizarEncargado(String id, EncargadoDto encargadoDto) {
        
        validaciones.validarCamposEncargado(encargadoDto);
        
        EncargadoEntity encargadoEntityEncontrado = iEncargadoRepository.findByIdEncargado(id);

        if(encargadoEntityEncontrado == null) {
            throw new ErrorException("encargado no encontrado");
        }

        if(!encargadoEntityEncontrado.getUsuarioEntity().getUsername().equals(encargadoDto.getUsername())) {
            throw new ErrorException("error al realizar la accion");
        }

        encargadoDto.setId(encargadoEntityEncontrado.getId());
        encargadoDto.setIdEncargado(encargadoEntityEncontrado.getIdEncargado());
        encargadoDto.setCreado(encargadoEntityEncontrado.getCreado());

        EncargadoEntity encargadoEntity = modelMapper.map(encargadoDto, EncargadoEntity.class);
        encargadoEntity.setUsuarioEntity(encargadoEntityEncontrado.getUsuarioEntity());

        iEncargadoRepository.save(encargadoEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public void eliminarEncargado(String username, String idEncargado) {
        
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(idEncargado);

        if(!encargadoEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        iEncargadoRepository.delete(encargadoEntity);
    }
    
}
