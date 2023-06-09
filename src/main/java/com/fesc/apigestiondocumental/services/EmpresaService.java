package com.fesc.apigestiondocumental.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IEmpresaRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.utils.FiltroArchivo;
import com.fesc.apigestiondocumental.utils.Validaciones;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    Validaciones validaciones;

    @Autowired
    FiltroArchivo filtroArchivo;

    @Override
    public RespuestaDto crearEmpresa(EmpresaDto empresaDto) {

        validaciones.validarCamposEmpresa(empresaDto);

        if(iEmpresaRepository.findByNomEmpresa(empresaDto.getNomEmpresa()) != null) {
            throw new ErrorException("empresa ya existe");
        }
        
        if(iEmpresaRepository.findByNit(empresaDto.getNit()) != null) {
            throw new ErrorException("nit ya existe");
        }

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(empresaDto.getUsername());

        EmpresaEntity empresaEntity = modelMapper.map(empresaDto, EmpresaEntity.class);
        empresaEntity.setIdEmpresa(UUID.randomUUID().toString());
        empresaEntity.setUsuarioEntity(usuarioEntity);

        iEmpresaRepository.save(empresaEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public EmpresaDto leerEmpresa(String username, String id) {
        
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(id);

        if(!empresaEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        EmpresaDto empresaDto = modelMapper.map(empresaEntity, EmpresaDto.class);

        return empresaDto;
    }

    @Override
    public List<InfoArchivoDto> listarArchivosEmpresa(String username, String busqueda, String filtro, String fecha) {

        // buscar por nombre de la empresa
        List<InfoArchivoEntity> infoArchivoEntityList = iInfoArchivoRepository.getByEmpresaEntityNomEmpresaOrderByCreadoDesc(busqueda);

        // el usuario tambien puede hacer la busqueda por el nit
        if(infoArchivoEntityList.size() == 0) {
            infoArchivoEntityList = iInfoArchivoRepository.getByEmpresaEntityNitOrderByCreadoDesc(busqueda);
        }

        // tambien puede hacer la busqueda por el numero de radicado en 
        // caso de no tener resultados en las busquedas anteriores
        if(infoArchivoEntityList.size() == 0) {
            infoArchivoEntityList = iInfoArchivoRepository.findByNumRadicado(busqueda);
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
    public RespuestaDto actualizarEmpresa(String id, EmpresaDto empresaDto) {

        validaciones.validarCamposEmpresa(empresaDto);

        EmpresaEntity empresaEntityEncontrada = iEmpresaRepository.findByIdEmpresa(id);

        if(empresaEntityEncontrada == null) {
            throw new ErrorException("empresa no encontrado");
        }

        if(!empresaEntityEncontrada.getUsuarioEntity().getUsername().equals(empresaDto.getUsername())) {
            throw new ErrorException("error al realizar la accion");
        }

        empresaDto.setId(empresaEntityEncontrada.getId());
        empresaDto.setIdEmpresa(empresaEntityEncontrada.getIdEmpresa());
        empresaDto.setCreado(empresaEntityEncontrada.getCreado());

        EmpresaEntity empresaEntity = modelMapper.map(empresaDto, EmpresaEntity.class);
        empresaEntity.setUsuarioEntity(empresaEntityEncontrada.getUsuarioEntity());
        
        iEmpresaRepository.save(empresaEntity);

        return new RespuestaDto(new Date(), true);
    }

    @Override
    public void eliminarEmpresa(String username, String idEmpresa) {
        
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(idEmpresa);

        if(!empresaEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }
        
        iEmpresaRepository.delete(empresaEntity);
    }
    
}
