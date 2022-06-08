package com.example.trackingforgym.data;

public class Noden<T> {

    T data;
    Noden<T> izq;
    Noden<T> der;

    public Noden<T> getIzq() {
        return izq;
    }

    public void setIzq(Noden<T> i) {
        izq = i;
    }

    public Noden<T> getDer() {
        return der;
    }

    public void setDer(Noden<T> i) {
        der = i;
    }

    public void setData(T i) {
        data = i;
    }

    public T getData() {
        return data;
    }

    public Boolean izqEmpty() {
        return izq == null;
    }

    public Boolean derEmpty() {
        return der == null;
    }

  /*public Node<T>() {
    this(null);
  }*/

    public Noden(T datas) {
        this.data = datas;
        izq = null;
        der = null;
    }
}
