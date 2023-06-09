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

import com.fesc.apigestiondocumental.models.peticiones.EncargadoActualizarRequestModel;
import com.fesc.apigestiondocumental.models.peticiones.EncargadoRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EncargadoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.RespuestaDataRestModel;
import com.fesc.apigestiondocumental.services.IEncargadoService;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

@RestController
@RequestMapping("/encargado")
public class EncargadoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEncargadoService iEncargadoService;

    @PostMapping
    public RespuestaDataRestModel crearEncargado(@RequestBody EncargadoRequestModel encargadoRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EncargadoDto encargadoDto = modelMapper.map(encargadoRequestModel, EncargadoDto.class);
        encargadoDto.setUsername(username);
        
        RespuestaDto respuestaDto = iEncargadoService.crearEncargado(encargadoDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public EncargadoDataRestModel leerEncargado(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EncargadoDto encargadoDto = iEncargadoService.leerEncargado(username, id);

        EncargadoDataRestModel encargadoDataRestModel = modelMapper.map(encargadoDto, EncargadoDataRestModel.class);

        return encargadoDataRestModel;
    }

    @PutMapping(path = "/{id}")
    public RespuestaDataRestModel actualizarEncargado(@PathVariable String id, @RequestBody EncargadoActualizarRequestModel encargadoActualizarRequestModel ) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EncargadoDto encargadoDto = modelMapper.map(encargadoActualizarRequestModel, EncargadoDto.class);
        encargadoDto.setUsername(username);

        RespuestaDto respuestaDto = iEncargadoService.actualizarEncargado(id, encargadoDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @DeleteMapping(path = "/{id}")
    public RespuestaDataRestModel eliminarEncargado(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        iEncargadoService.eliminarEncargado(username, id);

        return new RespuestaDataRestModel(new Date(), true);
    }
}
