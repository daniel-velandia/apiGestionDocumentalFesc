package com.fesc.apigestiondocumental.services;

import com.fesc.apigestiondocumental.shared.EstudianteDto;

public interface IEstudianteService {
    
    public EstudianteDto crearEstudiante(EstudianteDto estudianteDto);

    public EstudianteDto detalleEstudiante(String id);
}
