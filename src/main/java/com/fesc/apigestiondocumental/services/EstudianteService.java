package com.fesc.apigestiondocumental.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEstudianteRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.utils.FiltroArchivo;
import com.fesc.apigestiondocumental.utils.Validaciones;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEstudianteRepository iEstudianteRepository;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    Validaciones validaciones;

    @Autowired
    FiltroArchivo filtroArchivo;

    @Override
    public RespuestaDto crearEstudiante(EstudianteDto estudianteDto) {

        validaciones.validarCamposEstudiante(estudianteDto);

        if(iEstudianteRepository.findByCorreo(estudianteDto.getCorreo()) != null) {
            throw new ErrorException("correo ya existe");
        }

        if(iEstudianteRepository.findByDocumento(estudianteDto.getDocumento()) != null) {
            throw new ErrorException("documento ya existe");
        }

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(estudianteDto.getUsername());
        
        EstudianteEntity estudianteEntity = modelMapper.map(estudianteDto, EstudianteEntity.class);
        estudianteEntity.setIdEstudiante(UUID.randomUUID().toString());
        estudianteEntity.setUsuarioEntity(usuarioEntity);

        iEstudianteRepository.save(estudianteEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public EstudianteDto leerEstudiante(String username, String id) {
        
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(id);

        if(!estudianteEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        EstudianteDto estudianteDto = modelMapper.map(estudianteEntity, EstudianteDto.class);

        return estudianteDto;
    }

    @Override
    public List<InfoArchivoDto> listarArchivosEstudiante(String username, String busqueda, String filtro, String fecha) {

        // obtener lista por documento
        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByEstudianteEntityDocumentoOrderByCreadoDesc(busqueda);

        // el usuario tambien puede buscar por numero de radicado
        if(infoArchivoEntityList.size() == 0) {
            infoArchivoEntityList = iInfoArchivoRepository.findByNumRadicado(busqueda);
        }

        // el usuario tambien puede buscar por nombre y apellido
        if(infoArchivoEntityList.size() == 0) {
            String[] nombreCompleto = busqueda.split(" ");
            String nombre = nombreCompleto[0];
            String apellido = nombreCompleto[1];
            infoArchivoEntityList = iInfoArchivoRepository.getByEstudianteEntityNombreAndEstudianteEntityApellidoOrderByCreadoDesc(nombre, apellido);
        }

        if(!infoArchivoEntityList.get(0).getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        List<InfoArchivoDto> infoArchivoDtoList = new ArrayList<InfoArchivoDto>();

        for (InfoArchivoEntity infoArchivoEntity : infoArchivoEntityList) {
            
            InfoArchivoDto infoArchivoDto = modelMapper.map(infoArchivoEntity, InfoArchivoDto.class);

            infoArchivoDtoList.add(infoArchivoDto);
            
        }

        List<InfoArchivoDto> infoArchivoDtoListFiltrados = filtroArchivo.filtrarBusqueda(filtro, fecha, infoArchivoDtoList);
        
        return infoArchivoDtoListFiltrados;
    }

    @Override
    public RespuestaDto actualizarEstudiante(String id, EstudianteDto estudianteDto) {

        validaciones.validarCamposEstudiante(estudianteDto);
        
        EstudianteEntity estudianteEntityEncontrado = iEstudianteRepository.findByIdEstudiante(id);

        if(estudianteEntityEncontrado == null) {
            throw new ErrorException("estudiante no encontrado");
        }

        if(!estudianteEntityEncontrado.getUsuarioEntity().getUsername().equals(estudianteDto.getUsername())) {
            throw new ErrorException("error al realizar la accion");
        }
        
        // si el estudiante cambia de carrera se requiere crear un nuevo registro para tener un seguimiento
        if(!estudianteDto.getCarrera().equals(estudianteEntityEncontrado.getCarrera())) {
            estudianteDto.setIdEstudiante(UUID.randomUUID().toString());
        } else {
            estudianteDto.setId(estudianteEntityEncontrado.getId());
            estudianteDto.setIdEstudiante(estudianteEntityEncontrado.getIdEstudiante());
        }
        
        estudianteDto.setCreado(estudianteEntityEncontrado.getCreado());

        EstudianteEntity estudianteEntity = modelMapper.map(estudianteDto, EstudianteEntity.class);
        estudianteEntity.setUsuarioEntity(estudianteEntityEncontrado.getUsuarioEntity());

        iEstudianteRepository.save(estudianteEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public void eliminarEstudiante(String username, String idEstudiante) {
        
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(idEstudiante);

        if(!estudianteEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        iEstudianteRepository.delete(estudianteEntity);
    }
    
}
