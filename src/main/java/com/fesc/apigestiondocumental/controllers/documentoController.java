package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.DocumentoCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.DocumentoDataRestModel;
import com.fesc.apigestiondocumental.services.IDocumentoService;
import com.fesc.apigestiondocumental.shared.DocumentoDto;

@RestController
@RequestMapping("/documento")
public class documentoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IDocumentoService iDocumentoService;
    
    @PostMapping
    public DocumentoDataRestModel crearDocumento(@RequestBody DocumentoCrearRequestModel documentoCrearRequestModel) {

        String username = "TheKosky02";

        DocumentoDto documentoDto = modelMapper.map(documentoCrearRequestModel, DocumentoDto.class);
        documentoDto.setUsername(username);

        DocumentoDto documentoDtoCreado = iDocumentoService.crearDocumento(documentoDto);

        DocumentoDataRestModel documentoDataRestModel = modelMapper.map(documentoDtoCreado, DocumentoDataRestModel.class);

        return documentoDataRestModel;
    }
}
