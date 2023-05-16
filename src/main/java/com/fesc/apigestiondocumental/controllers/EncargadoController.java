package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.EncargadoCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EncargadoDataRestModel;
import com.fesc.apigestiondocumental.services.IEncargadoService;
import com.fesc.apigestiondocumental.shared.EncargadoDto;

@RestController
@RequestMapping("/encargado")
public class EncargadoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEncargadoService iEncargadoService;

    @PostMapping
    public EncargadoDataRestModel crearencargado(@RequestBody EncargadoCrearRequestModel encargadoCrearRequestModel) {

        EncargadoDto encargadoDto = modelMapper.map(encargadoCrearRequestModel, EncargadoDto.class);

        EncargadoDto encargadoDtoCreado = iEncargadoService.crearEncargado(encargadoDto);

        EncargadoDataRestModel encargadoDataRestModel = modelMapper.map(encargadoDtoCreado, EncargadoDataRestModel.class);

        return encargadoDataRestModel;
    }
}
