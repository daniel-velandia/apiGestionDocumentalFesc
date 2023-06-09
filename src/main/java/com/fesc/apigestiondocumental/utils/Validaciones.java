package com.fesc.apigestiondocumental.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fesc.apigestiondocumental.Errors.ErrorException;
import com.fesc.apigestiondocumental.shared.EmpresaDto;
import com.fesc.apigestiondocumental.shared.EncargadoDto;
import com.fesc.apigestiondocumental.shared.EstudianteDto;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.shared.UsuarioDto;

public class Validaciones {
    
    public void validarCamposArchivo(InfoArchivoDto infoArchivoDto) {
        if(infoArchivoDto.getNombre() == null || infoArchivoDto.getNumRadicado() == null ||
                infoArchivoDto.getTipoDocumento() == null || infoArchivoDto.getAsunto() == null ||
                infoArchivoDto.getAnexos() == null || infoArchivoDto.getEstudiante() == null ||
                infoArchivoDto.getEmpresa() == null || infoArchivoDto.getEncargado() == null ||
                infoArchivoDto.getEntrega() == null || infoArchivoDto.getArchivoEntity().getDatos() == null) {

            throw new ErrorException("campos sin diligenciar");
        }
    }

    public void validarCamposEmpresa(EmpresaDto empresaDto) {

        if(empresaDto.getNomEmpresa() == null || empresaDto.getNit() == null || empresaDto.getCorreo() == null ||
                empresaDto.getNombreAsistente() == null || empresaDto.getTelefono() == null) {
            
            throw new ErrorException("campos sin diligenciar");
        }

        String patron = "@";
        Pattern pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(empresaDto.getCorreo());

        if (!matcher.find()) {
            throw new ErrorException("el correo no tiene el formato especificado");
        }
    }

    public void validarCamposEncargado(EncargadoDto encargadoDto) {

        if(encargadoDto.getDocumento() == null || encargadoDto.getNombre() == null || 
                encargadoDto.getApellido() == null || encargadoDto.getCorreo() == null || 
                encargadoDto.getTelefono() == null || encargadoDto.getArea() == null || encargadoDto.getCargo() == null) {

            throw new ErrorException("campos no diligenciados");
        }

        validarCorreo(encargadoDto.getCorreo());
    }

    public void validarCamposEstudiante(EstudianteDto estudianteDto) {

        if(estudianteDto.getDocumento() == null || estudianteDto.getNombre() == null || 
                    estudianteDto.getApellido() == null || estudianteDto.getCorreo() == null || 
                    estudianteDto.getTelefono() == null || estudianteDto.getCarrera() == null || 
                    estudianteDto.getSemestre() == null) {

            throw new ErrorException("campos no diligenciados");
        }

        validarCorreo(estudianteDto.getCorreo());
        
    }

    public void validarCamposUsuario(UsuarioDto usuarioDto) {

        if(usuarioDto.getDocumento() == null || usuarioDto.getUsername() == null ||
                usuarioDto.getNombre() == null || usuarioDto.getApellido() == null ||
                usuarioDto.getCorreo() == null || usuarioDto.getTelefono() == null ||
                usuarioDto.getPassword() == null || usuarioDto.getCargo() == null) {

            throw new ErrorException("campos sin diligenciar");
        }

        validarCorreo(usuarioDto.getCorreo());
    }

    private void validarCorreo(String correo) {
        String patron = "@fesc\\.edu\\.co$";
        Pattern pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);

        if (!matcher.find()) {
            throw new ErrorException("el correo debe de tener el dominio de la FESC");
        }
    }
}
