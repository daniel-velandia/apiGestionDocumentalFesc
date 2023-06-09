package com.fesc.apigestiondocumental.controllers;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.ArchivoActualizarRequestModel;
import com.fesc.apigestiondocumental.models.peticiones.ArchivoRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.ArchivoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.InfoArchivoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.RespuestaDataRestModel;
import com.fesc.apigestiondocumental.services.IArchivoService;
import com.fesc.apigestiondocumental.shared.ArchivoDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IArchivoService iArchivoService;
    
    @PostMapping
    public RespuestaDataRestModel crearArchivo(@RequestBody ArchivoRequestModel archivoRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        ArchivoDto archivoDto = modelMapper.map(archivoRequestModel, ArchivoDto.class);
        InfoArchivoDto infoArchivoDto = modelMapper.map(archivoRequestModel, InfoArchivoDto.class);

        infoArchivoDto.setUsername(username);
        infoArchivoDto.setArchivoEntity(archivoDto);

        RespuestaDto respuestaDto = iArchivoService.crearArchivo(infoArchivoDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public InfoArchivoDataRestModel leerArchivo(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        InfoArchivoDto infoArchivoDto = iArchivoService.leerArchivo(username, id);

        InfoArchivoDataRestModel infoArchivoDataRestModel = modelMapper.map(infoArchivoDto, InfoArchivoDataRestModel.class);

        return infoArchivoDataRestModel;
    }

    @GetMapping(path = "/datos/{id}")
    public ArchivoDataRestModel leerDatosArchivo(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        ArchivoDto archivoDto = iArchivoService.leerDatosArchivo(username, id);

        ArchivoDataRestModel archivoDataRestModel = modelMapper.map(archivoDto, ArchivoDataRestModel.class);

        return archivoDataRestModel;
    }

    @PutMapping(path = "/{id}")
    public RespuestaDataRestModel actualizarArchivo(@PathVariable String id, @RequestBody ArchivoActualizarRequestModel archivoActualizarRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        InfoArchivoDto infoArchivoDto = modelMapper.map(archivoActualizarRequestModel, InfoArchivoDto.class);
        infoArchivoDto.setUsername(username);

        RespuestaDto respuestaDto =  iArchivoService.actualizarArchivo(id, infoArchivoDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @DeleteMapping(path = "/{id}")
    public RespuestaDataRestModel eliminarArchivo(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        iArchivoService.eliminarArchivo(username, id);

        return new RespuestaDataRestModel(new Date(), true);
    }
}
