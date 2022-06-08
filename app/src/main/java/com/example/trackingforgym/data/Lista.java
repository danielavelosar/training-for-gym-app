package com.example.trackingforgym.data;

public class Lista<T>{
    private Node<T> head;
    private Node<T> rear;
    Boolean found;
    int size;

    public int getSize(){
        return size;
    }

    public void pushFront(T i){
        Node<T> n=new Node<T>(i);
        n.setNext(head);
        head=n;
        if (head.getNext()==null)
            rear=head;
        size+=1;
    }
    public T get(int i){
        int c=0;
        Node<T> node= head;
        if (i==c)
            return node.getData();
        return get(i,c+1,node.getNext());
    }

    public T get(int i, int c, Node<T> node){
        if(c==i)
            return node.getData();
        return get(i,c+1,node.getNext());
    }

    public Node<T> getN(int i){
        int c=0;
        Node<T> node= head;
        if (i==c)
            return node;
        return getN(i,c+1,node.getNext());
    }

    public Node<T> getN(int i, int c, Node<T> node){
        if(c==i)
            return node;
        return getN(i,c+1,node.getNext());
    }

    public void pop(int i){
        Node<T> n = getN(i);
        n.setData(n.getNext().getData());
        n.setNext(n.getNext().getNext());
    }

    public T topFront(){
        return head.getData();
    }
    public Node<T> popFront(){
        if(!empty()){
            Node<T> ret =head;
            if(head.getNext()==null)
                rear=null;
            head=head.getNext();
            size-=1;
            return ret;
        }
        else return null;
    }
    public void pushBack(T i){
        if(empty())
            pushFront(i);
        else{
            Node<T> n=new Node<T>(i);
            rear.setNext(n);
            rear=n;
            size+=1;
        }
    }
    public T topBack(){
        return rear.getData();
    }
    public Node<T> popBack(){
        if (!empty()){
            Node<T> ret =rear;
            Node<T> pre=null;
            if(size>1){
                pre=find(rear);
                pre.setNext(null);
            }
            else if(size==1)
                head=null;
            rear=pre;
            size-=1;
            return ret;
        }
        else return null;
    }
    public Node<T> find(Node<T> n){
        Node<T> last = head;
        if (!empty()){
            while (last.getNext() != null && !found){
                if (last.getNext()==n)
                    return last;
                last=last.getNext();
            }
        }
        return null;
    }
    public boolean empty(){
        return head==null;
    }

    public void addBefore(Node<T> n, T i){
        if(!empty()){
            if(size==1)
                pushFront(n.getData());
            else{
                Node<T> prev=find(n);
                Node<T> newp=new Node<T>(i);
                prev.setNext(newp);
                newp.setNext(n);
            }
            size+=1;
        }
    }
    public void addAfter(Node<T> n, T i){
        if(!empty()){
            if(size>1){
                Node<T> nex=n.getNext();
                Node<T> newp=new Node<T>(i);
                n.setNext(newp);
                newp.setNext(nex);
                size+=1;
            }
            else
                pushBack(i);
        }
    }

    public Lista(){
        head=null;
        rear=null;
        size=0;
        found=false;
    }

    public void print(){
        System.out.print("[");
        if(!empty()){
            System.out.print(head.getData());
            if(head.getNext()!=null)
                print(head.getNext());
        }
        System.out.println("]");
    }

    private void print(Node<T> a){
        System.out.print(", "+a.getData());
        if(a.getNext()!=null)
            print(a.getNext());
    }
}
