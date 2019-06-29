package com.iankoulski.problems.ccibook.tg;


/*
Problem: 
Check if a binary tree is a binary search tree.
For a binary search tree node.left.data <= node.data < node.right.data is true for all lower level nodes.
The second example here is invalid because even though 2<9, 9 > 5, so 9 should've been to the right of 5.

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
Valid == true

Input:
                  5
                /   \
               3     7
              / \   / \
             2   4 6   8
            / \         
           1   9        

Output:
Balanced == false

Algo:
This will be a recursive algorithm similar to depth-first search.
We will pass the min and max value down the recursion stack to ensure each left branch
is less than or equal to the max and each right branch is greater than the min.
If we find a violation of these conditions we return false, if we reach the end of the tree
we return true.

*/

public class CheckBinarySearchTree {

    public static void main( String[] args ){
        System.out.println("\n=========================v Check Binary Search Tree v======================\n");

        CheckBinarySearchTree checkBST = new CheckBinarySearchTree();
        
        System.out.println("Input: Binary search tree");
        BinaryTreeNode<Integer> binarySearchTree = checkBST.getTestTree(true);
        boolean valid = checkBST.isBinarySearchTree(binarySearchTree);
        System.out.println("Output: valid == " + valid);

        System.out.println("\nInput: Not a binary search tree");
        BinaryTreeNode<Integer> binaryTree = checkBST.getTestTree(false);
        valid = checkBST.isBinarySearchTree(binaryTree);
        System.out.println("Output: valid == " + valid);
    
        System.out.println("\n=========================^ Check Binary Search Tree ^======================\n");
    }

    public boolean isBinarySearchTree(BinaryTreeNode<Integer> root){
        if (root==null) return false;
        return isBinarySearchTree(root.left,null,root.data) && isBinarySearchTree(root.right,root.data,null);
    }

    // Runtime: O(N), Space: O(log N), where log N is the depth of the tree
    private boolean isBinarySearchTree(BinaryTreeNode<Integer> node, Integer min, Integer max){
        if (node==null) return true;
        if ( min!=null && node.data <= min ) return false;
        if ( max!=null && node.data > max ) return false;
        return isBinarySearchTree(node.left, min, node.data) && isBinarySearchTree(node.right, node.data, max);
    }

    public BinaryTreeNode<Integer> getTestTree(boolean valid) {
        
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> nine = new BinaryTreeNode<Integer>(9);
        if (valid){
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
            two.right=nine;
        }
        return five;
    }
    
}