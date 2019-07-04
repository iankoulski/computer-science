package com.iankoulski.problems.ccibook.tg;

import java.util.ArrayList;

public class GraphNode<T> {
    public T data;
    public GraphNode<T>[] children;
    boolean visited = false;
    boolean processing = false;

    public GraphNode(T d){
        this.data=d;
    }

    public void addChild(GraphNode<T> child){
        ArrayList<GraphNode<T>> childArray = new ArrayList<GraphNode<T>>();
        if (children!=null){
            for (GraphNode<T> c : children){
                childArray.add(c);
            }
        }
        childArray.add(child);
        children = childArray.toArray(new GraphNode[childArray.size()]);
    }
}