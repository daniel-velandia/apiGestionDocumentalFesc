package com.fesc.apigestiondocumental.services;

import java.util.List;

import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;

public interface IEmpresaService {
    
    public RespuestaDto crearEmpresa(EmpresaDto empresaDto);

    public EmpresaDto leerEmpresa(String username, String id);

    public List<InfoArchivoDto> listarArchivosEmpresa(String username, String busqueda, String filtro, String fecha);

    public RespuestaDto actualizarEmpresa(String id, EmpresaDto empresaDto);

    public void eliminarEmpresa(String username, String idEmpresa);
}
