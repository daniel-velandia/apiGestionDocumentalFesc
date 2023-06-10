package com.fesc.apigestiondocumental.services;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.fesc.apigestiondocumental.Errors.ErrorException;
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
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.RespuestaDto;
import com.fesc.apigestiondocumental.utils.Validaciones;

@Service
public class ArchivoService implements IArchivoService{

    @Autowired
    JavaMailSenderImpl javaMailSenderImpl;

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

    @Autowired
    Validaciones validaciones;

    @Override
    public RespuestaDto crearArchivo(InfoArchivoDto infoArchivoDto) {

        validaciones.validarCamposArchivo(infoArchivoDto);

        ArchivoEntity archivoEntity = modelMapper.map(infoArchivoDto.getArchivoEntity(), ArchivoEntity.class);
        InfoArchivoEntity infoArchivoEntity = modelMapper.map(infoArchivoDto, InfoArchivoEntity.class);
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(infoArchivoDto.getUsername());
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(infoArchivoDto.getEstudiante());
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(infoArchivoDto.getEncargado());
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(infoArchivoDto.getEmpresa());
        InfoArchivoEntity infoArchivoEntityEntrega = iInfoArchivoRepository.findByIdInfoArchivo(infoArchivoDto.getEntrega());

        enviarMensaje(encargadoEntity.getCorreo(), infoArchivoEntity.getAsunto(), infoArchivoEntity.getAnexos(), 
                    usuarioEntity.getCorreo(), usuarioEntity.getPasswordApp(), infoArchivoDto.isInformarEncargado());

        archivoEntity.setIdArchivo(UUID.randomUUID().toString());
        ArchivoEntity archivoEntityCreado = iArchivoRepository.save(archivoEntity);

        if(empresaEntity != null && estudianteEntity == null) {

            infoArchivoEntity.setEmpresaEntity(empresaEntity);

        } else if(estudianteEntity != null && empresaEntity == null){

            infoArchivoEntity.setEstudianteEntity(estudianteEntity);
        } else {

            throw new ErrorException("Se debe agregar un remitente para el archivo (estudiante o empresa)");
        }

        // validar y asignar la entrega
        if (!infoArchivoEntity.isTipoRadicado()) {

            if(infoArchivoEntityEntrega != null && infoArchivoEntityEntrega.isReqRespuesta()) {

                infoArchivoEntity.setEntregaEntity(infoArchivoEntityEntrega);
            } else {

                throw new ErrorException("verifique si agrego el archivo a responder o si este requiere respuesta");
            }
        }

        infoArchivoEntity.setIdInfoArchivo(UUID.randomUUID().toString());
        infoArchivoEntity.setUsuarioEntity(usuarioEntity);
        infoArchivoEntity.setEncargadoEntity(encargadoEntity);
        infoArchivoEntity.setPeso(String.valueOf(archivoEntityCreado.getDatos().length));
        infoArchivoEntity.setArchivoEntity(archivoEntityCreado);

        iInfoArchivoRepository.save(infoArchivoEntity);

        return new RespuestaDto(new Date(), true);

    }

    @Override
    public InfoArchivoDto leerArchivo(String username, String id) {
        
        InfoArchivoEntity infoArchivoEntity = iInfoArchivoRepository.findByIdInfoArchivo(id);

        if(!infoArchivoEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        InfoArchivoDto infoArchivoDto = modelMapper.map(infoArchivoEntity, InfoArchivoDto.class);

        return infoArchivoDto;
    }

    @Override
    public ArchivoDto leerDatosArchivo(String username, String id) {

        InfoArchivoEntity infoArchivoEntity = iInfoArchivoRepository.findByIdInfoArchivo(id);

        if(!infoArchivoEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        ArchivoDto archivoDto = modelMapper.map(infoArchivoEntity.getArchivoEntity(), ArchivoDto.class);

        return archivoDto;
    }

    @Override
    public RespuestaDto actualizarArchivo(String id, InfoArchivoDto infoArchivoDto) {

        validaciones.validarCamposArchivo(infoArchivoDto);
        
        InfoArchivoEntity infoArchivoEntityEncontrado = iInfoArchivoRepository.findByIdInfoArchivo(id);

        if(infoArchivoEntityEncontrado == null) {
            throw new ErrorException("archivo no encontrado");
        }

        ArchivoEntity archivoEntity = modelMapper.map(infoArchivoDto.getArchivoEntity(), ArchivoEntity.class);
        InfoArchivoEntity infoArchivoEntity = modelMapper.map(infoArchivoDto, InfoArchivoEntity.class);

        EstudianteEntity estudianteEntity = iEstudianteRepository.findByIdEstudiante(infoArchivoDto.getEstudiante());
        EncargadoEntity encargadoEntity = iEncargadoRepository.findByIdEncargado(infoArchivoDto.getEncargado());
        EmpresaEntity empresaEntity = iEmpresaRepository.findByIdEmpresa(infoArchivoDto.getEmpresa());
        InfoArchivoEntity infoArchivoEntityEntrega = iInfoArchivoRepository.findByIdInfoArchivo(infoArchivoDto.getEntrega());

        archivoEntity.setId(infoArchivoEntityEncontrado.getArchivoEntity().getId());
        archivoEntity.setIdArchivo(infoArchivoEntityEncontrado.getArchivoEntity().getIdArchivo());

        infoArchivoEntity.setId(infoArchivoEntityEncontrado.getId());
        infoArchivoEntity.setIdInfoArchivo(infoArchivoEntityEncontrado.getIdInfoArchivo());
        infoArchivoEntity.setCreado(infoArchivoEntityEncontrado.getCreado());
        infoArchivoEntity.setPeso(String.valueOf(archivoEntity.getDatos().length));
        infoArchivoEntity.setUsuarioEntity(infoArchivoEntityEncontrado.getUsuarioEntity());
        infoArchivoEntity.setEstudianteEntity(estudianteEntity);
        infoArchivoEntity.setEmpresaEntity(empresaEntity);
        infoArchivoEntity.setEncargadoEntity(encargadoEntity);
        infoArchivoEntity.setArchivoEntity(archivoEntity);
        infoArchivoEntity.setEntregaEntity(infoArchivoEntityEntrega);

        iInfoArchivoRepository.save(infoArchivoEntity);

        return new RespuestaDto(new Date(), true);

    }

    @Override
    public void eliminarArchivo(String username, String idInfoArchivo) {
        
        InfoArchivoEntity infoArchivoEntity = iInfoArchivoRepository.findByIdInfoArchivo(idInfoArchivo);

        if(!infoArchivoEntity.getUsuarioEntity().getUsername().equals(username)) {
            throw new ErrorException("error al realizar la accion");
        }

        iInfoArchivoRepository.delete(infoArchivoEntity);

    }

    public void enviarMensaje(String para, String sunto, String cuerpo, String correo, String passwordApp, boolean informarEncargado) {

        try {
            
            if(passwordApp != null && informarEncargado) {

                SimpleMailMessage mensaje = new SimpleMailMessage();

                mensaje.setTo(para);
                mensaje.setSubject(sunto);
                mensaje.setText(cuerpo);

                javaMailSenderImpl.setUsername(correo);
                javaMailSenderImpl.setPassword(passwordApp);
                javaMailSenderImpl.send(mensaje);
                
            } else if (passwordApp == null && informarEncargado) {
    
                throw new ErrorException("No has agregado la contraseña de aplicación");
            }

        } catch (Exception e) {
            throw new ErrorException("error al enviar email");
        }
    }
    
}
