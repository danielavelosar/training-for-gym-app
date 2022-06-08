package com.example.trackingforgym.data;

public class Bst{
    public Noden<RutineHistoric> raiz;
    public int size;
    RutineHistoric search;

    public void inOrder(){
        System.out.print("in order: ");
        inOrder(raiz);
    }

    public void inOrder(Noden<RutineHistoric> i){
        if (i!=null){
            if (!i.izqEmpty())
                inOrder(i.getIzq());
            System.out.print(i.getData().getNombre()+" ");
            if (!i.derEmpty())
                inOrder(i.getDer());
        }
    }

    public Noden<RutineHistoric> find(int num){
        return find(num,raiz);
    }
    public Noden<RutineHistoric> find(int num, Noden<RutineHistoric> n){

        if (n.getData().fechaInt== num)
            return n;
        else if(n.getData().fechaInt > num){
            if (n.izq !=null)
                return find(num, n.izq);
            return n;
        }
        else if(n.getData().fechaInt < num){
            if (n.der !=null)
                return find(num, n.der);
            return n;
        }
        return n;
    }

    public Noden<RutineHistoric> remove(RutineHistoric num){
        size--;
        return remove(num, raiz);
    }

    public Noden<RutineHistoric> remove(RutineHistoric num, Noden<RutineHistoric> n){
        if (n == null) {
            return n;
        } else if (n.data.fechaInt > num.fechaInt) {
            n.izq = remove(num,n.izq);
        } else if (n.data.fechaInt < num.fechaInt) {
            n.der = remove(num, n.der);
        } else {
            if (n.izq == null || n.der == null) {
                n = (n.izq == null) ? n.der : n.izq;
            } else {
                Noden<RutineHistoric> mostLeftChild = buscarMenor(n.der);
                n.data = mostLeftChild.data;
                n.der = remove(n.data,n.der);
            }
        }

        return n;
    }
    public Noden<RutineHistoric> buscarMenor(Noden<RutineHistoric> n){
        if(n.izq !=null)
            return buscarMenor(n.izq);
        return n;
    }

    public Noden<RutineHistoric> insertar(RutineHistoric num){
        size++;
        return insertar(num, raiz);
    }
    public Noden<RutineHistoric> insertar(RutineHistoric num, Noden<RutineHistoric> n){
        if (n==null)
            return new Noden<RutineHistoric>(num);
        if(num.fechaInt>n.getData().fechaInt)
            n.der =insertar(num, n.der);
        if(num.fechaInt<n.getData().fechaInt)
            n.izq =insertar(num, n.izq);
        return n;
    }

    public Bst(){
        size=0;
        raiz=null;
    }

    public Bst(RutineHistoric a){
        raiz = new Noden<RutineHistoric>(a);
        /*for (int i: a){
            this.insertar(i, raiz);
        }
        size=a.length;*/
    }


    public RutineHistoric get(int s){
        inOrder(raiz,0,s);
        return search;
    }

    public int inOrder(Noden<RutineHistoric> i, int n, int s){
        if (i!=null){
            if (!i.izqEmpty()){
                n = inOrder(i.getIzq(),n,s);
            }
            if(n==s)
                search=i.data;
            n++;
            if (!i.derEmpty())
                n=inOrder(i.getDer(),n,s);
            return n;
        }
        return 0;
    }
}

