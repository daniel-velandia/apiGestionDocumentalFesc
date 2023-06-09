package com.fesc.apigestiondocumental.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apigestiondocumental.models.peticiones.UsuarioActualizarRequestModel;
import com.fesc.apigestiondocumental.models.peticiones.UsuarioRequestModel;
import com.fesc.apigestiondocumental.models.respuestas.EmpresaDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.EncargadoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.EstudianteDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.InfoArchivoDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.RespuestaDataRestModel;
import com.fesc.apigestiondocumental.models.respuestas.UsuarioDataRestModel;
import com.fesc.apigestiondocumental.services.IUsuarioService;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping
    public RespuestaDataRestModel crearUsuario(@RequestBody UsuarioRequestModel usuarioRequestModel) {

        UsuarioDto usuarioDto = modelMapper.map(usuarioRequestModel, UsuarioDto.class);

        RespuestaDto respuestaDto = iUsuarioService.crearUsuario(usuarioDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @GetMapping
    public UsuarioDataRestModel leerUsuario() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioService.leerUsuario(username);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

        return usuarioDataRestModel;
    }
    
    @PutMapping
    public RespuestaDataRestModel actualizarUsuario(@RequestBody UsuarioActualizarRequestModel usuarioActualizarRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();
        
        UsuarioDto usuarioDto = modelMapper.map(usuarioActualizarRequestModel, UsuarioDto.class);

        RespuestaDto respuestaDto = iUsuarioService.actualizarUsuario(username, usuarioDto);

        RespuestaDataRestModel respuestaDataRestModel = modelMapper.map(respuestaDto, RespuestaDataRestModel.class);

        return respuestaDataRestModel;
    }

    @DeleteMapping
    public RespuestaDataRestModel eliminarUsuario() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        iUsuarioService.eliminarUsuario(username);

        return new RespuestaDataRestModel(new Date(), true);
    }

    @GetMapping(path = "/misArchivos")
    public List<InfoArchivoDataRestModel> listarArchivos(@RequestParam(name = "tipo", required = false) String tipo) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<InfoArchivoDto> infoArchivoDtoList = iUsuarioService.listarArchivos(username, tipo);

        List<InfoArchivoDataRestModel> infoArchivoDataRestModelList = new ArrayList<InfoArchivoDataRestModel>();

        for (InfoArchivoDto infoArchivoDto : infoArchivoDtoList) {
            
            InfoArchivoDataRestModel infoArchivoDataRestModel = modelMapper.map(infoArchivoDto, InfoArchivoDataRestModel.class);

            infoArchivoDataRestModelList.add(infoArchivoDataRestModel);
        }

        return infoArchivoDataRestModelList;
    }

    @GetMapping(path = "/misEstudiantes")
    public List<EstudianteDataRestModel> listarEstudiantes() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<EstudianteDto> estudianteDtoList = iUsuarioService.listarEstudiantes(username);

        List<EstudianteDataRestModel> estudianteDataRestModels = new ArrayList<EstudianteDataRestModel>();

        for (EstudianteDto estudianteDto : estudianteDtoList) {
            
            EstudianteDataRestModel estudianteDataRestModel = modelMapper.map(estudianteDto, EstudianteDataRestModel.class);

            estudianteDataRestModels.add(estudianteDataRestModel);
        }

        return estudianteDataRestModels;
    }

    @GetMapping(path = "/misEncargados")
    public List<EncargadoDataRestModel> listarEncargados() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<EncargadoDto> encargadoDtoList = iUsuarioService.listarEncargados(username);

        List<EncargadoDataRestModel> encargadoDataRestModelList = new ArrayList<EncargadoDataRestModel>();

        for (EncargadoDto encargadoDto : encargadoDtoList) {
            
            EncargadoDataRestModel encargadoDataRestModel = modelMapper.map(encargadoDto, EncargadoDataRestModel.class);

            encargadoDataRestModelList.add(encargadoDataRestModel);
        }

        return encargadoDataRestModelList;
    }

    @GetMapping(path = "/misEmpresas")
    public List<EmpresaDataRestModel> listarEmpresas() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<EmpresaDto> empresaDtoList = iUsuarioService.listarEmpresas(username);

        List<EmpresaDataRestModel> EmpresaDataRestModelList = new ArrayList<EmpresaDataRestModel>();

        for (EmpresaDto empresaDto : empresaDtoList) {
            
            EmpresaDataRestModel empresaDataRestModel = modelMapper.map(empresaDto, EmpresaDataRestModel.class);

            EmpresaDataRestModelList.add(empresaDataRestModel);
        }

        return EmpresaDataRestModelList;
    }
}
