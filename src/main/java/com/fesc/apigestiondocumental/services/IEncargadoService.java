package com.fesc.apigestiondocumental.services;

import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

public interface IEncargadoService {
    
    public RespuestaDto crearEncargado(EncargadoDto encargadoDto);

    public EncargadoDto leerEncargado(String username, String id);

    public RespuestaDto actualizarEncargado(String id, EncargadoDto encargadoDto);

    public void eliminarEncargado(String username, String idEncargado);
}
