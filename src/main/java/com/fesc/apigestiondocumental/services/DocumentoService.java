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
import com.fesc.apigestiondocumental.shared.DocumentoDto;

@Service
public class DocumentoService implements IDocumentoService{

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
    public DocumentoDto crearDocumento(DocumentoDto documentoDto) {

        ArchivoEntity archivoEntity = modelMapper.map(documentoDto, ArchivoEntity.class);
        archivoEntity.setIdArchivo(UUID.randomUUID().toString());
        
        try {
            Path path = Path.of("C:/Users/usuario/Downloads/EJERCICIODEREFUERZO.pdf");
            archivoEntity.setDatos(Files.readAllBytes(path));
        } catch (IOException e) {
            archivoEntity.setDatos(null);
        }

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(documentoDto.getUsername());
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(documentoDto.getEstudiante());
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(documentoDto.getEncargado());
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(documentoDto.getEmpresa());

        ArchivoEntity archivoEntityCreado = iArchivoRepository.save(archivoEntity);

        InfoArchivoEntity infoArchivoEntity = modelMapper.map(documentoDto, InfoArchivoEntity.class);
        infoArchivoEntity.setIdInfoArchivo(UUID.randomUUID().toString());
        infoArchivoEntity.setArchivoEntity(archivoEntityCreado);
        infoArchivoEntity.setUsuarioEntity(usuarioEntity);
        infoArchivoEntity.setEstudianteEntity(estudianteEntity);
        infoArchivoEntity.setEmpresaEntity(empresaEntity);
        infoArchivoEntity.setEncargadoEntity(encargadoEntity);

        InfoArchivoEntity infoArchivoEntityCreado = iInfoArchivoRepository.save(infoArchivoEntity);

        DocumentoDto documentoDtocreado = modelMapper.map(infoArchivoEntityCreado, DocumentoDto.class);
        
        return documentoDtocreado;
    }
    
}
