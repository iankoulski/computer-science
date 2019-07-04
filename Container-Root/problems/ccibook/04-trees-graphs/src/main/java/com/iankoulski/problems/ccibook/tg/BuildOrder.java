package com.iankoulski.problems.ccibook.tg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/*
Problem:
Given a list of projects and a list of dependencies (e.g. (a,b) meaning project b depends on project a), 
find a build order that will allow all projects to be built. If there is no valid build order return an error.

Example:

Input:
projects: a,b,c,d,e,f,g
dependencies: (a,d), (f,b), (b,d), (f,a), (d,c), (b,g)

Output:
f,e,a,b,d,c

Graph: 
    f   g   e
   / \ /
  a   b
   \ /  
    d  
    |
    c 


Algo:
This problem is known as "topological sort" - order the vertices of a graph linearly 
so that for every edge (a,b) a appears before b.

# Approach 1
1) Build a graph from the projects and dependencies
2) Do a depth-first search starting at the root of the graph, adding the deepest node
   to the end of the build order and each prent node before that. A stack is appropriate
   for keeping track of the build order. Keep track of visited nodes. 
   Throw error if loop is detected, because then there is a circular dependency and build is not possible.
3) If there is more than one root, repeat the process for each root.

# Approach 2
Projects that dont have any dependencies can be built immediately ... these are all the roots
1) Find all roots, add to build
2) Remove roots from the tree and repeat process (find nodes that have no parents and build)
   if there are no roots but the tree has nodes, then there is a dependency loop

*/


public class BuildOrder {

    public Graph<String> buildGraph(String[] projects, String[][] dependencies){
        
        Graph<String> g = new Graph<String>();
        HashMap<String,GraphNode<String>> nodeMap = new HashMap<String,GraphNode<String>>();
        
        for (String project: projects){
            GraphNode<String> node = new GraphNode<String>(project);
            nodeMap.put(project,node);
        }

        for (String[] dependency : dependencies){
            GraphNode<String> parent = nodeMap.get(dependency[0]);
            GraphNode<String> child = nodeMap.get(dependency[1]);
            parent.addChild(child);
        }
        Collection<GraphNode<String>> nodeCollection  = nodeMap.values();
        GraphNode<String>[] nodeArray = nodeCollection.toArray(new GraphNode[nodeCollection.size()]);
        g.nodes = nodeArray;
        g.nodeMap = nodeMap;

        return g;
    }

    public static void main(String[] args){
        System.out.println("----------------------v Build Order v----------------------");
        BuildOrder bo = new BuildOrder();
        String[] projects = new String[] {"a","b","c","d","e","f","g"};
        String[][] dependencies = new String[][] {{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"},{"g","b"}};
        Graph<String> g = bo.buildGraph(projects, dependencies);
        System.out.println("Input: \n  projects = " + Arrays.toString(projects) + 
                                  "\n  dependencies = " + Arrays.deepToString(dependencies));
        
        Stack<String> buildOrderStack = bo.getBuildOrderByDFS(g);
        System.out.println("Output (DFS approach): " + ((buildOrderStack==null) ? null : buildOrderStack.getString()) + " (expected g->f->a->b->d->c->e)");
        Queue<String> buildOrderQueue = bo.getBuildOrderByRoot(g);
        System.out.println("Output (Root approach): " + ((buildOrderQueue==null) ? null : buildOrderQueue.getString()) + " (expected e<-f<-g<-a<-b<-d<-c)");
        System.out.println("----------------------^ Build Order ^----------------------");
    }

    public Queue<String> getBuildOrderByRoot(Graph<String> g) {
        Queue<String> buildOrder = new Queue<String>();
        List<GraphNode<String>> roots = findRoots(g);
        if (roots==null) return null;
        while (roots.size()>0){
            for (GraphNode<String> root : roots){
                buildOrder.add(root.data);
                g.removeNode(root);
            }
            roots = findRoots(g);
            if (roots==null) return null;
        }
        return buildOrder;
    }

    Stack<String> getBuildOrderByDFS(Graph<String> g) {
        Stack<String> buildOrder = new Stack<String>();
        //find roots - roots have 0 dependencies
        HashMap<String,GraphNode<String>> nodeMap = g.nodeMap;
        List<GraphNode<String>> roots = findRoots(g);
        if (roots.size() == 0) return null; // circular dependencies exist
        //dfs from all roots
        for (GraphNode<String> root : roots){
            boolean success = DFS(root,buildOrder); // success if no circular dependencies
            if (!success) return null;
        }
        return buildOrder;
    }

    boolean DFS(GraphNode<String> node, Stack<String> stack){
        boolean success = true;

        if (node.processing) return false; // loop detected

        node.processing = true;
        if (node.children != null) {
            for (GraphNode<String> child : node.children){
                if (!child.visited)
                  success = DFS(child, stack);
            }
        }
        stack.push(node.data);
        node.visited = true;
        node.processing = false;

        return success;
    }

    List<GraphNode<String>> findRoots(Graph<String> g){
        List<GraphNode<String>> roots = new ArrayList<GraphNode<String>>();
        HashMap<String,Integer> depCounts = new HashMap<String,Integer>();
        if (g.nodes!=null){
            for (GraphNode<String> node: g.nodes){
                if (node.children!=null){
                    for (GraphNode<String> child: node.children){
                        depCounts.put(child.data, depCounts.containsKey(child.data) ? (depCounts.get(child.data)+1):1);
                    }
                }
            }
        }
        // nodes that are not in depCounts have 0 dependencies and are roots
        if (g.nodes!=null){
            for (GraphNode<String> node : g.nodes){
                if (!depCounts.containsKey(node.data)) roots.add(node);
            }
        }
        if (depCounts.size()>0 && roots.size()==0) return null;
        return roots;
    }
}