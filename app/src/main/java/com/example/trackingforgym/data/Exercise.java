package com.example.trackingforgym.data;

public class Exercise {
    private int id;
    private int idRutine;
    private String colorExercise;
    private String nombreExercise;

    public Exercise(int id, int idRutine, String colorExercise, String nombreExercise ){
        this.id=id;
        this.idRutine=idRutine;
        this.colorExercise=colorExercise;
        this.nombreExercise=nombreExercise;
    }
    public Exercise(String colorExercise, String nombreExercise ){
        this(0,0,colorExercise,nombreExercise);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRutine() {
        return idRutine;
    }

    public void setIdRutine(int idRutine) {
        this.idRutine = idRutine;
    }

    public String getColor() {
        return colorExercise;
    }

    public void setColor(String color) {
        this.colorExercise = color;
    }

    public String getNombre() {
        return nombreExercise;
    }

    public void setNombre(String nombre) {
        this.nombreExercise = nombre;
    }
}
