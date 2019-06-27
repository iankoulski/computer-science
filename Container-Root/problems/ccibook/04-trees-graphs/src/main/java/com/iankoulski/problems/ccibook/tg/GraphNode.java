package com.iankoulski.problems.ccibook.tg;

public class GraphNode<T> {
    public T data;
    public GraphNode<T>[] children;
    boolean visited = false;

    public GraphNode(T d){
        this.data=d;
    }
}