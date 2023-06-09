package com.fesc.apigestiondocumental.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;
import com.fesc.apigestiondocumental.data.entidades.EncargadoEntity;
import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEmpresaRepository;
import com.fesc.apigestiondocumental.data.repositorios.IEncargadoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IEstudianteRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.shared.UsuarioDto;
import com.fesc.apigestiondocumental.utils.Validaciones;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

    @Autowired
    IEstudianteRepository iEstudianteRepository;

    @Autowired
    IEncargadoRepository iEncargadoRepository;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    Validaciones validaciones;

    @Override
    public RespuestaDto crearUsuario(UsuarioDto usuarioDto) {

        validaciones.validarCamposUsuario(usuarioDto);

        if(iUsuarioRepository.findByUsername(usuarioDto.getUsername()) != null) {
            throw new ErrorException("username ya existe");
        }

        if(iUsuarioRepository.findByCorreo(usuarioDto.getCorreo()) != null) {
            throw new ErrorException("correo ya existe");
        }

        if(iUsuarioRepository.findByDocumento(usuarioDto.getDocumento()) != null) {
            throw new ErrorException("documento ya existe");
        }
        
        UsuarioEntity usuarioEntity = modelMapper.map(usuarioDto, UsuarioEntity.class);
        usuarioEntity.setIdUsuario(UUID.randomUUID().toString());
        usuarioEntity.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioDto.getPassword()));

        iUsuarioRepository.save(usuarioEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public UsuarioDto leerUsuario(String username) {
       
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(username);

        UsuarioDto usuarioDto = modelMapper.map(usuarioEntity, UsuarioDto.class);

        return usuarioDto;
    }

    @Override
    public RespuestaDto actualizarUsuario(String username, UsuarioDto usuarioDto) {

        validaciones.validarCamposUsuario(usuarioDto);

        UsuarioEntity usuarioEntityAutenticado = iUsuarioRepository.findByUsername(username);

        usuarioDto.setId(usuarioEntityAutenticado.getId());
        usuarioDto.setIdUsuario(usuarioEntityAutenticado.getIdUsuario());
        usuarioDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioDto.getPassword()));

        UsuarioEntity usuarioEntity = modelMapper.map(usuarioDto, UsuarioEntity.class);

        iUsuarioRepository.save(usuarioEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public void eliminarUsuario(String username) {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(username);

        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByUsuarioEntityUsernameOrderByCreadoDesc(username);

        iInfoArchivoRepository.deleteAll(infoArchivoEntityList);

        iUsuarioRepository.delete(usuarioEntity);

    }

    @Override
    public List<InfoArchivoDto> listarArchivos(String username, String tipo) {
        
        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByUsuarioEntityUsernameOrderByCreadoDesc(username);

        List<InfoArchivoDto> infoArchivoDtoList = new ArrayList<InfoArchivoDto>();

        for (InfoArchivoEntity infoArchivoEntity : infoArchivoEntityList) {
            
            InfoArchivoDto infoArchivoDto = modelMapper.map(infoArchivoEntity, InfoArchivoDto.class);

            infoArchivoDtoList.add(infoArchivoDto);
        }

        if(tipo != null) {

            infoArchivoDtoList.removeIf(infoArchivoDto ->
                tipo.equals("entrega") ? !infoArchivoDto.isTipoRadicado() :
                        (tipo.equals("respuesta") ? infoArchivoDto.isTipoRadicado() : true));
        }

        return infoArchivoDtoList;
    }

    @Override
    public List<EstudianteDto> listarEstudiantes(String username) {
        
        List<EstudianteEntity> estudianteEntityList = iEstudianteRepository.getByUsuarioEntityUsernameOrderByCreadoDesc(username);

        List<EstudianteDto> estudianteDtoList = new ArrayList<EstudianteDto>();

        for (EstudianteEntity estudianteEntity : estudianteEntityList) {
            
            EstudianteDto estudianteDto = modelMapper.map(estudianteEntity, EstudianteDto.class);

            estudianteDtoList.add(estudianteDto);
        }

        return estudianteDtoList;
    }

    @Override
    public List<EncargadoDto> listarEncargados(String username) {
        
        List<EncargadoEntity> encargadoEntityList = iEncargadoRepository.getByUsuarioEntityUsernameOrderByCreadoDesc(username);

        List<EncargadoDto> encargadoDtoList = new ArrayList<EncargadoDto>();

        for (EncargadoEntity encargadoEntity : encargadoEntityList) {
            
            EncargadoDto encargadoDto = modelMapper.map(encargadoEntity, EncargadoDto.class);

            encargadoDtoList.add(encargadoDto);
        }

        return encargadoDtoList;
    }

    @Override
    public List<EmpresaDto> listarEmpresas(String username) {

        List<EmpresaEntity> empresaEntityList = iEmpresaRepository.getByUsuarioEntityUsernameOrderByCreadoDesc(username);

        List<EmpresaDto> empresaDtoList = new ArrayList<EmpresaDto>();

        for (EmpresaEntity empresaEntity : empresaEntityList) {
            
            EmpresaDto empresaDto = modelMapper.map(empresaEntity, EmpresaDto.class);

            empresaDtoList.add(empresaDto);
        }

        return empresaDtoList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(username);
     
        if(usuarioEntity ==  null) {
            throw new UsernameNotFoundException(username);
        }

        User usuario = new User(usuarioEntity.getUsername(), usuarioEntity.getPasswordEncriptada(), new ArrayList<>());

        return usuario;

    }
    
}
