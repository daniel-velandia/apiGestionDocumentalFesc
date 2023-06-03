package com.fesc.apigestiondocumental.services;

import java.util.List;

import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

public interface IEstudianteService {
    
    public RespuestaDto crearEstudiante(EstudianteDto estudianteDto);

    public EstudianteDto leerEstudiante(String username, String id);

    public List<InfoArchivoDto> listarArchivosEstudiante(String username, String busqueda, String filtro, String fecha);

    public RespuestaDto actualizarEstudiante(String id, EstudianteDto estudianteDto);

    public void eliminarEstudiante(String username, String idEstudiante);
}
