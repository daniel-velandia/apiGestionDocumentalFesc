package com.fesc.apigestiondocumental.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fesc.apigestiondocumental.Errors.ErrorException;

public class Correo {

    @Autowired
    JavaMailSenderImpl javaMailSenderImpl;
    
    public void enviarCorreo(String para, String sunto, String cuerpo, String correo, String passwordApp, boolean informarEncargado) {

        try {
            
            if(!informarEncargado) {
                return;
            }

            if(passwordApp != null) {

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
