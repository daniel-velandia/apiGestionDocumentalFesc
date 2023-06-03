package com.fesc.apigestiondocumental.shared;

import java.util.Date;

public class RespuestaDto {
    
    private Date fecha;
    private boolean respuesta;

    public RespuestaDto(Date fecha, boolean respuesta) {
        this.fecha = fecha;
        this.respuesta = respuesta;
    }
    
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public boolean isRespuesta() {
        return respuesta;
    }
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}
