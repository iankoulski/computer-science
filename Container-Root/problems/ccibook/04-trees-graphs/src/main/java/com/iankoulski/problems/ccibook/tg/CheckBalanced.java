package com.iankoulski.problems.ccibook.tg;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
Problem: 
Create a function to check if a binary tree is balanced. A tree is balanced if the hights 
of the two subtrees of any node never differ by more than one.

Example:
Input:
                  5
                /   \
               3     7
              / \   / \
             2   4 6   8
            /           \
           1             9

Output:
Balanced == true

Input:
                  5
                /   \
               3     7
              / \   
             2   4 
            /   / \ 
           1   6   8
                    \
                     9

Output:
Balanced == false

Algo:
Need a function that returns the height of a tree given its root node.
Use breadth first traversal to compare heights of left and right children. Break if difference of more than 1 is found.

*/

public class CheckBalanced {

    public static void main( String[] args ){
        System.out.println("\n=========================v Check Balanced v======================\n");

        CheckBalanced cb = new CheckBalanced();
        
        System.out.println("Input: Balanced binary tree");
        BinaryTreeNode<Integer> balancedTree = cb.getTestTree(true);
        boolean balanced = cb.isBalanced(balancedTree);
        System.out.println("Output: balanced == " + balanced);

        System.out.println("\nInput: Imbalanced binary tree");
        BinaryTreeNode<Integer> imbalancedTree = cb.getTestTree(false);
        balanced = cb.isBalanced(imbalancedTree);
        System.out.println("Output: balanced == " + balanced);
    
        System.out.println("\n=========================^ Check Balanced ^======================\n");
    }

    // Time: O(N), space O(H)
    public boolean isBalanced(BinaryTreeNode<Integer> root){
        if (root==null) return false;
        try{
            int heightLeft = getHeight(root.left);
            int heightRight = getHeight(root.right);
            int diff = Math.abs(heightLeft-heightRight);
            if (diff>1) return false;            
        }catch(ImbalancedTreeException ite) {
            return false;
        }
        return true;
    }

    private int getHeight(BinaryTreeNode<Integer> node) throws ImbalancedTreeException {
        if (node==null) return 0;
        int heightLeft = getHeight(node.left);
        int heightRight = getHeight(node.right);
        int diff = Math.abs(heightLeft-heightRight);
        if (diff>1) throw new ImbalancedTreeException();
        return Math.max(heightLeft,heightRight)+1;
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
        }else{
            five.left=three;
            five.right=seven;
            three.left=two;
            three.right=four;
            two.left=one;
            four.left=six;
            four.right=eight;
            eight.right=nine;
        }
        return five;
    }

    class ImbalancedTreeException extends RuntimeException{
        private static final long serialVersionUID = 1L;

        public ImbalancedTreeException() {
            super();
        }
    }
    
}