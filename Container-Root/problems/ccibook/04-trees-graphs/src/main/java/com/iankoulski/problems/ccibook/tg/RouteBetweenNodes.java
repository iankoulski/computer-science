package com.iankoulski.problems.ccibook.tg;


/*
Problem:
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Example:
Graph: 
    5
   /|\
  3 6 4
 / \   \
7   8   9

Input:  Start: 3, End: 9
Output: False

Input:  Start: 5, End: 9
Output: True

Algo:

Traverse graph starting at node "Start". 
  At each node, check if current node is "End". 
  If yes, then return true
  else continue traversing
If graph is traversed and there is no match return false.
*/

public class RouteBetweenNodes {

    public Graph<Integer> getTestGraph(){
        GraphNode<Integer> root = new GraphNode<Integer>(5);
        GraphNode<Integer> three = new GraphNode<Integer>(3);
        GraphNode<Integer> six = new GraphNode<Integer>(6);
        GraphNode<Integer> four = new GraphNode<Integer>(4);
        root.children = new GraphNode[] {three, six, four};
        GraphNode<Integer> seven = new GraphNode<Integer>(7);
        GraphNode<Integer> eight = new GraphNode<Integer>(8);
        GraphNode<Integer> nine = new GraphNode<Integer>(9);
        three.children = new GraphNode[] {seven, eight};
        four.children = new GraphNode[] {nine};
        Graph<Integer> g = new Graph();
        g.nodes = new GraphNode[] {root,three,six,four,seven,eight,nine};
        return g;
    }

    public static void main(String[] args){
        System.out.println("----------------------v Route Between Nodes v----------------------");
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        Graph<Integer> g = rbn.getTestGraph();
        GraphNode<Integer> start = g.nodes[1];
        GraphNode<Integer> end = g.nodes[6];
        System.out.println("Input: Start = 3, End = 9");
        boolean pathExists = rbn.pathExists(g, start, end);
        System.out.println("Output: " + pathExists + " (expected false)");
        System.out.println("Input: Start = 5, End = 9");
        pathExists = rbn.pathExists(g, g.nodes[0], end);
        System.out.println("Output: " + pathExists + " (expected true)");
        System.out.println("----------------------^ Route Between Nodes ^----------------------");
    }

    boolean pathExists(Graph<Integer> g, GraphNode<Integer> start, GraphNode<Integer> end){
        // Breadth-first search usually provides shortest path
        for (GraphNode<Integer> node : g.nodes) node.visited=false;
        Queue<GraphNode<Integer>> q = new Queue<GraphNode<Integer>>();
        q.add(start);
        while (!q.isEmpty()){
            GraphNode<Integer> n = q.remove();
            n.visited=true;
            if (n.data == end.data) return true;
            if (n.children!=null){
                for (GraphNode<Integer> child : n.children){
                    if (!child.visited) q.add(child);
                }
            }
        }
        return false;
    }
}