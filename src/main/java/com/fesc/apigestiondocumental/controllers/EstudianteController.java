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

import com.fesc.apigestiondocumental.models.peticiones.EstudianteActualizarRequestModel;
import com.fesc.apigestiondocumental.models.peticiones.EstudianteRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EstudianteDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.InfoArchivoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.RespuestaDataRestModel;
import com.fesc.apigestiondocumental.services.IEstudianteService;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEstudianteService iEstudianteService;

    @PostMapping
    public RespuestaDataRestModel crearEstudiante(@RequestBody EstudianteRequestModel estudianteRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EstudianteDto estudianteDto = modelMapper.map(estudianteRequestModel, EstudianteDto.class);
        estudianteDto.setUsername(username);
        
        RespuestaDto respuestaDto = iEstudianteService.crearEstudiante(estudianteDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public EstudianteDataRestModel leerEstudiante(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EstudianteDto estudianteDto = iEstudianteService.leerEstudiante(username, id);

        EstudianteDataRestModel estudianteDataRestModel = modelMapper.map(estudianteDto, EstudianteDataRestModel.class);

        return estudianteDataRestModel;
    }

    @GetMapping(path = "/archivos/{busqueda}")
    public List<InfoArchivoDataRestModel> listarArchivosEstudiante(@PathVariable String busqueda, @RequestParam(name = "filtro", required = false) String filtro, @RequestParam(name = "fecha", required = false) String fecha) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<InfoArchivoDto> infoArchivoDtoList = iEstudianteService.listarArchivosEstudiante(username, busqueda, filtro, fecha);

        List<InfoArchivoDataRestModel> infoArchivoDataRestModelList = new ArrayList<InfoArchivoDataRestModel>();

        for (InfoArchivoDto infoArchivoDto : infoArchivoDtoList) {
            
            InfoArchivoDataRestModel infoArchivoDataRestModel = modelMapper.map(infoArchivoDto, InfoArchivoDataRestModel.class);

            infoArchivoDataRestModelList.add(infoArchivoDataRestModel);
        }

        return infoArchivoDataRestModelList;
    }

    @PutMapping(path = "/{id}")
    public RespuestaDataRestModel actualizarEstudiante(@PathVariable String id, @RequestBody EstudianteActualizarRequestModel estudianteActualizarRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        EstudianteDto estudianteDto = modelMapper.map(estudianteActualizarRequestModel, EstudianteDto.class);
        estudianteDto.setUsername(username);

        RespuestaDto respuestaDto = iEstudianteService.actualizarEstudiante(id, estudianteDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @DeleteMapping(path = "/{id}")
    public RespuestaDataRestModel eliminarEstudiante(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        iEstudianteService.eliminarEstudiante(username, id);

        return new RespuestaDataRestModel(new Date(), true);
    }
}
