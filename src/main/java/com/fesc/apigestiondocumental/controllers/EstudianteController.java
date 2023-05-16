package com.fesc.apigestiondocumental.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.EstudianteCrearRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EstudianteDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.EstudianteDetalleDataRestModel;
import com.fesc.apigestiondocumental.services.IEstudianteService;
import com.fesc.apigestiondocumental.shared.EstudianteDto;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEstudianteService iEstudianteService;

    @PostMapping
    public EstudianteDataRestModel crearEstudiante(@RequestBody EstudianteCrearRequestModel estudianteCrearRequestModel) {

        EstudianteDto estudianteDto = modelMapper.map(estudianteCrearRequestModel, EstudianteDto.class);

        EstudianteDto estudianteDtoCreado = iEstudianteService.crearEstudiante(estudianteDto);

        EstudianteDataRestModel estudianteDataRestModel = modelMapper.map(estudianteDtoCreado, EstudianteDataRestModel.class);

        return estudianteDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public EstudianteDetalleDataRestModel detalleEstudiante(@PathVariable String id) {

        EstudianteDto estudianteDto = iEstudianteService.detalleEstudiante(id);

        EstudianteDetalleDataRestModel estudianteDetalleDataRestModel = modelMapper.map(estudianteDto, EstudianteDetalleDataRestModel.class);

        return estudianteDetalleDataRestModel;
    }
}
