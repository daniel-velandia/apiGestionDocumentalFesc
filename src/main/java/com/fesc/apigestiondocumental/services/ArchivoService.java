package com.fesc.apigestiondocumental.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.data.entidades.ArchivoEntity;
import com.fesc.apigestiondocumental.data.entidades.EmpresaEntity;
import com.fesc.apigestiondocumental.data.entidades.EncargadoEntity;
import com.fesc.apigestiondocumental.data.entidades.EstudianteEntity;
import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.data.entidades.UsuarioEntity;
import com.fesc.apigestiondocumental.data.repositorios.IArchivoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IEmpresaRepository;
import com.fesc.apigestiondocumental.data.repositorios.IEncargadoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IEstudianteRepository;
import com.fesc.apigestiondocumental.data.repositorios.IInfoArchivoRepository;
import com.fesc.apigestiondocumental.data.repositorios.IUsuarioRepository;
import com.fesc.apigestiondocumental.shared.ArchivoDto;

@Service
public class ArchivoService implements IArchivoService{

    @Autowired
    IArchivoRepository iArchivoRepository;

    @Autowired
    IInfoArchivoRepository iInfoArchivoRepository;

    @Autowired
    IEstudianteRepository iEstudianteRepository;

    @Autowired
    IEncargadoRepository iEncargadoRepository;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArchivoDto crearArchivo(ArchivoDto archivoDto) {

        ArchivoEntity archivoEntity = modelMapper.map(archivoDto, ArchivoEntity.class);
        archivoEntity.setIdArchivo(UUID.randomUUID().toString());
        archivoEntity.setDatos(obtenerBytesArchivo());
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(archivoDto.getInfoArchivoEntity().getUsername());
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(archivoDto.getInfoArchivoEntity().getEstudiante());
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(archivoDto.getInfoArchivoEntity().getEncargado());
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(archivoDto.getInfoArchivoEntity().getEmpresa());

        InfoArchivoEntity infoArchivoEntity = modelMapper.map(archivoDto.getInfoArchivoEntity(), InfoArchivoEntity.class);
        infoArchivoEntity.setIdInfoArchivo(UUID.randomUUID().toString());
        infoArchivoEntity.setUsuarioEntity(usuarioEntity);
        infoArchivoEntity.setEstudianteEntity(estudianteEntity);
        infoArchivoEntity.setEmpresaEntity(empresaEntity);
        infoArchivoEntity.setEncargadoEntity(encargadoEntity);
        infoArchivoEntity.setPeso(String.valueOf(archivoEntity.getDatos().length));

        InfoArchivoEntity infoArchivoEntityCreado = iInfoArchivoRepository.save(infoArchivoEntity);

        archivoEntity.setInfoArchivoEntity(infoArchivoEntityCreado);
        ArchivoEntity archivoEntityCreado = iArchivoRepository.save(archivoEntity);

        ArchivoDto archivoDtoCreado = modelMapper.map(archivoEntityCreado, ArchivoDto.class);
        
        return archivoDtoCreado;
    }

    public byte[] obtenerBytesArchivo() {
        try {
            Path path = Path.of("C:/Users/usuario/Downloads/EJERCICIODEREFUERZO.pdf");
            return Files.readAllBytes(path);
        } catch (IOException e) {
            return null;
        }
    }
    
}
