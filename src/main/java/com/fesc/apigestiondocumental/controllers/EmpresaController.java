package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.EmpresaCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EmpresaDataRestModel;
import com.fesc.apigestiondocumental.services.IEmpresaService;
import com.fesc.apigestiondocumental.shared.EmpresaDto;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpresaService iEmpresaService;

    @PostMapping
    public EmpresaDataRestModel crearUsuario(@RequestBody EmpresaCrearRequestModel empresaCrearRequestModel) {

        EmpresaDto empresaDto = modelMapper.map(empresaCrearRequestModel, EmpresaDto.class);

        EmpresaDto empresaDtoCreado = iEmpresaService.crearEmpresa(empresaDto);

        EmpresaDataRestModel empresaDataRestModel = modelMapper.map(empresaDtoCreado, EmpresaDataRestModel.class);

        return empresaDataRestModel;
    }
}
