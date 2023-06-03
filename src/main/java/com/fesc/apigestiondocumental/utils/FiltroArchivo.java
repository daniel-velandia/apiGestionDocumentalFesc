package com.fesc.apigestiondocumental.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

public class FiltroArchivo {
    
    public List<InfoArchivoDto> filtrarBusqueda(String filtro, String fecha, List<InfoArchivoDto> infoArchivoDtoList) {
        
        if ((filtro == null || filtro.isEmpty()) && (fecha == null || fecha.isEmpty())) {
            return infoArchivoDtoList; 
        }

        if(filtro != null) {

            infoArchivoDtoList.removeIf(infoArchivoDto ->
                filtro.equals("entrega") ? !infoArchivoDto.isTipoRadicado() :
                        (filtro.equals("respuesta") ? infoArchivoDto.isTipoRadicado() : true));
        }

        if(fecha != null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaFiltro;
            try {
                fechaFiltro = LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                throw new ErrorException("Error al filtrar por fecha");
            }
        
            infoArchivoDtoList.removeIf(
                infoArchivoDto -> !infoArchivoDto.getCreado().isEqual(fechaFiltro));

        }

        return infoArchivoDtoList;
        
    }
}
