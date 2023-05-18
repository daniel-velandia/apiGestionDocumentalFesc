package com.fesc.apigestiondocumental.services;

import java.util.List;

import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

public interface IEstudianteService {
    
    public EstudianteDto crearEstudiante(EstudianteDto estudianteDto);

    public EstudianteDto detalleEstudiante(String id);

    public List<InfoArchivoDto> obtenerArchivosEstudiante(String id);
}
