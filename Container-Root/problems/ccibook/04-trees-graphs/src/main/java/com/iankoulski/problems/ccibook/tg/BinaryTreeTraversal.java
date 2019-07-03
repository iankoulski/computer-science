package com.iankoulski.problems.ccibook.tg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
Problem: 
Create a function to return the next node (in-order, pre-order, or post-order successor) of a given node in a binary tree. 
You may assume that each node has a link to its parent.

Example:
Input: 3, in-order
                  5
                /   \
               3     7
              / \   / \
             2   4 6   8
            /           \
           1             9

Output: 4

Input: 6, in-order
                  5
                /   \
               3     7
              / \   
             2   4 
            /   / \ 
           1   6   8
                    \
                     9

Output: 4

Algo:
Assuming elements in the tree are unique, perform a binary tree traversal until the specified node is reached,
then go forward one step to find and return the successor.

*/

enum TraversalMode{
    PreOrder, InOrder, PostOrder;
}

public class BinaryTreeTraversal {

    public static void main( String[] args ){
        System.out.println("\n=========================v Binary Tree Traversal v======================\n");

        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        
        System.out.println("Input: Balanced binary tree, node 3, in-order traversal");
        BinaryTreeNode<Integer> balancedTree = btt.getTestTree(true);
        Integer successorNode = btt.getSuccessor(balancedTree.left, TraversalMode.InOrder);
        System.out.println("Output: successor == " + successorNode);

        System.out.println("\nInput: Unbalanced binary tree, node 6, in-order traversal");
        BinaryTreeNode<Integer> unbalancedTree = btt.getTestTree(false);
        successorNode = btt.getSuccessor(unbalancedTree.left.right.left, TraversalMode.InOrder);
        System.out.println("Output: successor == " + successorNode);
    
        System.out.println("\nTraversals of balanced binary tree:");
        System.out.println("                  5         \n" +
                           "                /   \\      \n" +
                           "               3     7      \n" +
                           "              / \\   / \\   \n" +
                           "             2   4 6   8    \n" +
                           "            /           \\  \n" +
                           "           1             9  \n");

        System.out.println("Pre-Order : " + btt.getTraversal(balancedTree, TraversalMode.PreOrder).toString());
        System.out.println("In-Order  : " + btt.getTraversal(balancedTree, TraversalMode.InOrder).toString());
        System.out.println("Post-Order: " + btt.getTraversal(balancedTree, TraversalMode.PostOrder).toString());
        System.out.println("\n=========================^ Binary Tree Traversal ^======================\n");
    }

    // Time: O(N), space O(H)
    public Integer getSuccessor(BinaryTreeNode<Integer> node, TraversalMode traversalMode){
        if (node==null) return null;
        
        // Find tree root
        BinaryTreeNode<Integer> root = node;
        while(root.parent!=null) root = root.parent;

        // Get traversal
        LinkedList<Integer> traversal = getTraversal(root, traversalMode);
        Iterator<Integer> t = traversal.iterator();
        Integer successor = null;
        while (t.hasNext()){
            if (t.next() == node.data){
                try{
                    successor = t.next();
                }catch(NoSuchElementException e){
                    successor = null;
                }
                break;
            }
        }

        return successor;
    }

    public LinkedList<Integer> getTraversal(BinaryTreeNode<Integer> root, TraversalMode traversalMode){
        LinkedList<Integer> traversal = new LinkedList<Integer>();
        switch (traversalMode){
            case PreOrder:
                visitPreOrder(root,traversal);
                break;
            case InOrder:
                visitInOrder(root,traversal);
                break;
            case PostOrder:
                visitPostOrder(root,traversal);
                break;
        }
        return traversal;
    }

    void visitPreOrder(BinaryTreeNode<Integer> node, LinkedList<Integer> traversal){
        if (node!=null) {
            traversal.add(node.data);
            visitPreOrder(node.left, traversal);
            visitPreOrder(node.right, traversal);
        }
    }

    void visitInOrder(BinaryTreeNode<Integer> node, LinkedList<Integer> traversal){
        if (node!=null){
            visitInOrder(node.left, traversal);
            traversal.add(node.data);
            visitInOrder(node.right, traversal);
        }
    }

    void visitPostOrder(BinaryTreeNode<Integer> node, LinkedList<Integer> traversal){
        if (node!=null){
            visitInOrder(node.left, traversal);
            visitInOrder(node.right, traversal);
            traversal.add(node.data);
        }
    }


    public BinaryTreeNode<Integer> getTestTree(boolean balanced) {
        
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> nine = new BinaryTreeNode<Integer>(9);
        if (balanced){
            five.left=three;
            five.right=seven;
            three.left=two;
            three.right=four;
            two.left=one;
            seven.left=six;
            seven.right=eight;
            eight.right=nine;
            one.parent=two;
            two.parent=three;
            four.parent=three;
            three.parent=five;
            nine.parent=eight;
            eight.parent=seven;
            six.parent=seven;
            seven.parent=five;
        }else{
            five.left=three;
            five.right=seven;
            three.left=two;
            three.right=four;
            two.left=one;
            four.left=six;
            four.right=eight;
            eight.right=nine;
            nine.parent=eight;
            eight.parent=four;
            six.parent=four;
            four.parent=three;
            one.parent=two;
            two.parent=three;
            three.parent=five;
            seven.parent=five;
        }
        return five;
    }
    
}