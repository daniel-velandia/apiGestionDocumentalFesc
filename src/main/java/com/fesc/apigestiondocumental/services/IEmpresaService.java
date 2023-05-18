package com.fesc.apigestiondocumental.services;

import java.util.List;

import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;

public interface IEmpresaService {
    
    public EmpresaDto crearEmpresa(EmpresaDto empresaDto);

    public EmpresaDto detalleEmpresa(String id);

    public List<InfoArchivoDto> obtenerArchivosEmpresa(String id);
}
