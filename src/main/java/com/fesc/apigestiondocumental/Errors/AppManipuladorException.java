package com.fesc.apigestiondocumental.Errors;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fesc.apigestiondocumental.models.respuestas.MensajeErrorModel;

public class AppManipuladorException {
    
    @ExceptionHandler(value = {ErrorException.class})
    public ResponseEntity<Object> handleErrorException(ErrorException ex, WebRequest webRequest) {

        MensajeErrorModel mensajeErrorModel = new MensajeErrorModel(new Date(), ex.getMessage());

        return new ResponseEntity<>(mensajeErrorModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest) {

        MensajeErrorModel mensajeErrorModel = new MensajeErrorModel(new Date(), ex.getMessage());

        return new ResponseEntity<>(mensajeErrorModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
