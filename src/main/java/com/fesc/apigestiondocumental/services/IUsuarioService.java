package com.fesc.apigestiondocumental.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

public interface IUsuarioService extends UserDetailsService {
    
    public RespuestaDto crearUsuario(UsuarioDto usuarioDto);

    public UsuarioDto leerUsuario(String username);

    public RespuestaDto actualizarUsuario(String username, UsuarioDto usuarioDto);

    public void eliminarUsuario(String username);
    
    public List<InfoArchivoDto> listarArchivos(String username, String tipo);

    public List<EstudianteDto> listarEstudiantes(String username);

    public List<EncargadoDto> listarEncargados(String username);

    public List<EmpresaDto> listarEmpresas(String username);

}
