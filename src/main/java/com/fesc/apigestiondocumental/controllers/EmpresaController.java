package com.fesc.apigestiondocumental.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.EmpresaCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EmpresaDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.EmpresaDetalleDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.InfoArchivoDataRestModel;
import com.fesc.apigestiondocumental.services.IEmpresaService;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

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

    @GetMapping(path = "/{id}")
    public EmpresaDetalleDataRestModel detalleEmpresa(@PathVariable String id) {

        EmpresaDto empresaDto = iEmpresaService.detalleEmpresa(id);

        EmpresaDetalleDataRestModel empresaDetalleDataRestModel = modelMapper.map(empresaDto, EmpresaDetalleDataRestModel.class);

        return empresaDetalleDataRestModel;
    }

    @GetMapping(path = "/archivos/{id}")
    public List<InfoArchivoDataRestModel> obtenerArchivosEmpresa(@PathVariable String id) {

        List<InfoArchivoDto> infoArchivoDtoList = iEmpresaService.obtenerArchivosEmpresa(id);

        List<InfoArchivoDataRestModel> infoArchivoDataRestModelList = new ArrayList<InfoArchivoDataRestModel>();

        for (InfoArchivoDto infoArchivoDto : infoArchivoDtoList) {
            
            InfoArchivoDataRestModel infoArchivoDataRestModel = modelMapper.map(infoArchivoDto, InfoArchivoDataRestModel.class);

            infoArchivoDataRestModelList.add(infoArchivoDataRestModel);
        }

        return infoArchivoDataRestModelList;
    }
}
