package com.example.trackingforgym.data;

import java.util.Date;

public class RutineHistoric extends Rutine{
    private Date fecha;

    public RutineHistoric(String color, String nombre, Date fecha){
        super(color, nombre);
        this.fecha = fecha;
    }
    public RutineHistoric(String color, String nombre){
        super(color, nombre);
        fecha=null;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
