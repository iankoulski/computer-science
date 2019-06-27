package com.iankoulski.problems.ccibook.tg;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top;

    public Stack(){
        top = null;
    }

    public Stack(Node<T> n){
        top = n;
    }

    public void push(T d){
        Node<T> n = new Node<T>(d);
        n.next = top;
        top = n;
    }

	public T pop(){
        if (top==null) throw new EmptyStackException();
        T d = top.data;
        top = top.next;
        return d;
    }

    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public String getString(){
        StringBuilder sb = new StringBuilder();
        Node<T> n = top;
        while (n != null){
            sb.append(n.data.toString());
            if (n.next != null) sb.append ("->");
            n = n.next;
        }
        return sb.toString();
    }
}
