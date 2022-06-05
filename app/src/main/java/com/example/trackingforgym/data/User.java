package com.example.trackingforgym.data;

public class User {
    int id;
    String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public User(){
        this(-1,null);
    }

    public User(int ide){
        id=ide;
        correo=null;
    }
    public User(int ide, String email){
        id=ide;
        correo= email;
    }
}
