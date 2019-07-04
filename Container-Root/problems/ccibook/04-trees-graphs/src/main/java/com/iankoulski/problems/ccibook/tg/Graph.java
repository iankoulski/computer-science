package com.iankoulski.problems.ccibook.tg;

import java.util.HashMap;

public class Graph<T> {
    public GraphNode<T>[] nodes;
    public HashMap<T,GraphNode<T>> nodeMap;

    public void addEdge(GraphNode<T> parent, GraphNode<T> child){
        parent.addChild(child);
    }

    public void removeNode(GraphNode<T> node){
        if (nodeMap!=null){
            nodeMap.remove(node.data);
            GraphNode<T>[] a = new GraphNode[nodeMap.size()];
            nodes = nodeMap.values().toArray(a);
        }else{
            buildNodeMap();
        }
    }

    private void buildNodeMap() {
        nodeMap = new HashMap<T,GraphNode<T>>();
        if (nodes!=null){
            for (GraphNode<T> node : nodes){
                nodeMap.put(node.data, node);
            }
        }
    }
}