package com.fesc.apigestiondocumental.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        
        UsuarioEntity usuarioEntity = modelMapper.map(usuarioDto, UsuarioEntity.class);
        usuarioEntity.setIdUsuario(UUID.randomUUID().toString());
        usuarioEntity.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioDto.getPassword()));

        UsuarioEntity usuarioEntityCreado = iUsuarioRepository.save(usuarioEntity);

        UsuarioDto usuarioDtoCreado = modelMapper.map(usuarioEntityCreado, UsuarioDto.class);

        return usuarioDtoCreado;
    }
    
}
