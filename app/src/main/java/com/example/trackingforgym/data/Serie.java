package com.example.trackingforgym.data;

public class Serie extends Ejercicio{
    public int repeticiones;

    public Serie(int i, String nom, String col, String pc, int r){
        super(i,nom,col,pc);
        repeticiones=r;
    }
}
