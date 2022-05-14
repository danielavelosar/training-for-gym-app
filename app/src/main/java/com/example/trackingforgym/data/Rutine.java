package com.example.trackingforgym.data;

public class Rutine {

    private int id;
    private int idPropietario;
    private String color;
    private String nombre;

    public Rutine(int id, int idpropietario, String color, String nombre ){
        this.id=id;
        this.idPropietario=idpropietario;
        this.color=color;
        this.nombre=nombre;
    }
    public Rutine(String color, String nombre ){
        this(0,0,color,nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
