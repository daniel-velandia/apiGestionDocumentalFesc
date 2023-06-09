package com.fesc.apigestiondocumental.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.EmpresaActualizarRequestModel;
import com.fesc.apigestiondocumental.models.peticiones.EmpresaRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EmpresaDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.InfoArchivoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.RespuestaDataRestModel;
import com.fesc.apigestiondocumental.services.IEmpresaService;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpresaService iEmpresaService;

    @PostMapping
    public RespuestaDataRestModel crearEmpresa(@RequestBody EmpresaRequestModel empresaRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EmpresaDto empresaDto = modelMapper.map(empresaRequestModel, EmpresaDto.class);
        empresaDto.setUsername(username);

        RespuestaDto respuestaDto = iEmpresaService.crearEmpresa(empresaDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public EmpresaDataRestModel leerEmpresa(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EmpresaDto empresaDto = iEmpresaService.leerEmpresa(username, id);

        EmpresaDataRestModel empresaDataRestModel = modelMapper.map(empresaDto, EmpresaDataRestModel.class);

        return empresaDataRestModel;
    }

    @GetMapping(path = "/archivos/{busqueda}")
    public List<InfoArchivoDataRestModel> listarArchivosEmpresa(@PathVariable String busqueda, @RequestParam(name = "filtro", required = false) String filtro, @RequestParam(name = "fecha", required = false) String fecha) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<InfoArchivoDto> infoArchivoDtoList = iEmpresaService.listarArchivosEmpresa(username, busqueda, filtro, fecha);

        List<InfoArchivoDataRestModel> infoArchivoDataRestModelList = new ArrayList<InfoArchivoDataRestModel>();

        for (InfoArchivoDto infoArchivoDto : infoArchivoDtoList) {
            
            InfoArchivoDataRestModel infoArchivoDataRestModel = modelMapper.map(infoArchivoDto, InfoArchivoDataRestModel.class);

            infoArchivoDataRestModelList.add(infoArchivoDataRestModel);
        }

        return infoArchivoDataRestModelList;
    }

    @PutMapping(path = "/{id}")
    public RespuestaDataRestModel actualizarEmpresa(@PathVariable String id, @RequestBody EmpresaActualizarRequestModel empresaActualizarRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EmpresaDto empresaDto = modelMapper.map(empresaActualizarRequestModel, EmpresaDto.class);
        empresaDto.setUsername(username);

        RespuestaDto respuestaDto = iEmpresaService.actualizarEmpresa(id, empresaDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @DeleteMapping(path = "/{id}")
    public RespuestaDataRestModel eliminarEmpresa(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        iEmpresaService.eliminarEmpresa(username, id);

        return new RespuestaDataRestModel(new Date(), true);
    }
}
