package com.example.trackingforgym.data;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node () {
        data=null;
        next=null;
    }
    public Node(T dat) {
        this.data = dat;
        next = null;
    }
    public Node<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node<T> n) {
        next = n;
    }
    public void setData(T i) {
        data = i;
    }
}
