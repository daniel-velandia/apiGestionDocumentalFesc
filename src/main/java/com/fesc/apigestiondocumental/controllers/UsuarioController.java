package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.UsuarioCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.UsuarioDataRestModel;
import com.fesc.apigestiondocumental.services.IUsuarioService;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping
    public UsuarioDataRestModel crearUsuario(@RequestBody UsuarioCrearRequestModel usuarioCrearRequestModel) {

        UsuarioDto usuarioDto = modelMapper.map(usuarioCrearRequestModel, UsuarioDto.class);

        UsuarioDto usuarioDtoCreado = iUsuarioService.crearUsuario(usuarioDto);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDtoCreado, UsuarioDataRestModel.class);

        return usuarioDataRestModel;
    }
}
