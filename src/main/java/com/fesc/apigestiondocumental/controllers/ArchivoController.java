package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.ArchivoCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.ArchivoDataRestModel;
import com.fesc.apigestiondocumental.services.IArchivoService;
import com.fesc.apigestiondocumental.shared.ArchivoDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IArchivoService iArchivoService;
    
    @PostMapping
    public ArchivoDataRestModel crearArchivo(@RequestBody ArchivoCrearRequestModel archivoCrearRequestModel) {

        String username = "TheKosky02";

        ArchivoDto archivoDto = modelMapper.map(archivoCrearRequestModel, ArchivoDto.class);
        InfoArchivoDto infoArchivoDto = modelMapper.map(archivoCrearRequestModel, InfoArchivoDto.class);

        infoArchivoDto.setUsername(username);
        archivoDto.setInfoArchivoEntity(infoArchivoDto);

        ArchivoDto archivoDtoCreado = iArchivoService.crearArchivo(archivoDto);

        ArchivoDataRestModel archivoDataRestModel = modelMapper.map(archivoDtoCreado, ArchivoDataRestModel.class);

        return archivoDataRestModel;
    }
}
