package com.iankoulski.problems.ccibook.sq;

import java.util.NoSuchElementException;

public class Queue<T> {

    private Node<T> top = null;
    private Node<T> bottom = null;

    public void add(T d){
        Node<T> n = new Node<T>(d);
        if (top!=null){
            top.next = n; // add new elements to the top, pointers are from bottom to top
        }
        top=n;
        if (bottom==null) bottom = top;
    }

    public T remove(){
        if (bottom==null) throw new NoSuchElementException();
        T data = bottom.data;
        bottom=bottom.next;
        if (bottom==null) top=null;
        return data;
    }

    public T peek(){
        if (bottom == null) throw new NoSuchElementException();
        return bottom.data;
    }

    public boolean isEmpty(){
        return (bottom==null);
    }

    public String getString(){
        StringBuilder sb = new StringBuilder();
        Node<T> n = bottom;
        while (n != null){
            sb.append(n.data.toString());
            if (n.next != null) sb.append ("<-");
            n = n.next;
        }
        return sb.toString();
    }
}
