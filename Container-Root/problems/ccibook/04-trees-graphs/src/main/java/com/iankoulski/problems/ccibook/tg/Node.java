package com.iankoulski.problems.ccibook.tg;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T d){
        this.data=d;
    }
}