package com.example.trackingforgym.data;


import com.example.trackingforgym.R;

import java.util.ArrayList;

public class Bst{
    Node<Rutine> raiz;
    int size;
    public ArrayList<Rutine> ret;

    /*public ArrayList<Node<Integer>> rangeSearch(int x, int y, Node<Integer> n){
      n=find(x,raiz);
      ArrayList<Node<Integer>> L = new ArrayList<Node<Integer>>();
      while(n.getData()<=y){
        if(n.getData()>=x){
          L.add(n);
        }
        n=next(n);
      }
      return L;
    }
    */


    public Node<Rutine> insertar(Rutine num, Node<Rutine> n){
        if (n==null)
            return new Node<Rutine>(num);
        if(num.numero_usos>n.getData().numero_usos)
            n.der =insertar(num, n.der);
        if(num.numero_usos<n.getData().numero_usos)
            n.izq =insertar(num, n.izq);

        return n;
    }

    public Bst(){
        raiz=null;
    }

    public Bst(Rutine [] a){
        raiz = new Node<Rutine>(a[0]);
        for (Rutine i: a){
            this.insertar(i, raiz);
        }
        size=a.length;
        ret = new ArrayList<Rutine>();
    }

    public void inOrder(){
        inOrder(raiz);
    }

    public void inOrder(Node<Rutine> i){
        if (i!=null){
            if (!i.izqEmpty())
                inOrder(i.getIzq());
            ret.add(i.getData());
            if (!i.derEmpty())
                inOrder(i.getDer());
        }
    }
}

class Node <T>{

    T data;
    Node<T> izq;
    Node<T> der;

    public Node<T> getIzq(){
        return izq;
    }

    public void setIzq(Node<T> i){
        izq=i;
    }

    public Node<T> getDer(){
        return der;
    }

    public void setDer(Node<T> i){
        der=i;
    }

    public void setData(T i){
        data=i;
    }

    public T getData(){
        return data;
    }

    public Boolean izqEmpty(){
        return izq==null;
    }

    public Boolean derEmpty(){
        return der==null;
    }

  /*public Node<T>() {
    this(null);
  }*/

    public Node(T datas) {
        this.data = datas;
        izq = null;
        der = null;
    }

}