package com.fesc.apigestiondocumental.services;

import com.fesc.apigestiondocumental.shared.ArchivoDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

public interface IArchivoService {
    
    public RespuestaDto crearArchivo(InfoArchivoDto infoArchivoDto);

    public InfoArchivoDto leerArchivo(String username, String id);

    public ArchivoDto leerDatosArchivo(String username, String id);

    public RespuestaDto actualizarArchivo(String id, InfoArchivoDto infoArchivoDto);

    public void eliminarArchivo(String username, String idArchivo);
    
}
