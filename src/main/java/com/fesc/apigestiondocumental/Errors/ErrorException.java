package com.fesc.apigestiondocumental.Errors;

public class ErrorException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ErrorException(String mensaje) {
        super(mensaje);
    }
}
