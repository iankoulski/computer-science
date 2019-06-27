package com.iankoulski.problems.ccibook.tg;

import java.util.List;
import java.util.ArrayList;

/*
Problem: 
Given a sorted in incremental order array with unique integer elements, 
write an algorithm to create a binary search tree with minimal height.

Example:
Input: {1,2,3,4,5,6,7,8,9}
Output:
                  5
                /   \
               3     7
              / \   / \
             2   4 6   8
            /           \
           1             9

Algo:
Minimal hight means that the tree is as balanced as possible. 
Find middle of array - this is the root element
Split array to left and right subarray
Find middle of each subarray - this is the next element
Continue until there are no more splittable subarrays.
Make sure all array elements get included.

*/

public class MinimalTree {

    public static void main( String[] args ){
        System.out.println("=========================v Minimal Tree v======================");
        MinimalTree mt = new MinimalTree();
        int[] array = new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println("Input: " + java.util.Arrays.toString(array) );
        BinaryTreeNode<Integer> bst = mt.buildBinarySearchTree(array);       
        System.out.println("Output (root node): " + bst.data);
        System.out.println("Output (traversal in-order): " + mt.traverseInOrder(bst).toString());
        System.out.println("=========================^ Minimal Tree ^======================");
    }


    public BinaryTreeNode<Integer> buildBinarySearchTree(int[] array){
        return buildBinarySearchSubtree(array,0,array.length-1);
    }

    // Runtime O(N)
    public BinaryTreeNode<Integer> buildBinarySearchSubtree(int[] array, int start, int end){
        if (array==null || array.length==0) return null;
        if (array.length==1) return new BinaryTreeNode<Integer>(array[0]); 
        int middleIndex = (start + end)/2;
        int element = array[middleIndex];
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(element);
        if ( middleIndex > start)
            node.left = buildBinarySearchSubtree(array,start,middleIndex-1);
        if (end > middleIndex)
            node.right = buildBinarySearchSubtree(array,middleIndex+1,end);
        return node;
    }

    public List<Integer> traverseInOrder(BinaryTreeNode<Integer> r){
		List<Integer> traversal = new ArrayList<Integer>();
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();
		s.push(r);

		while (!s.isEmpty()){
			BinaryTreeNode<Integer> n = s.peek();
			if (n.left!=null){
				s.push(n.left);
				n.left=null;
			}else{
				traversal.add(n.data);
				s.pop();
				if (n.right!=null){
					s.push(n.right);
				}
			}
		}

		return traversal;
    }
    
}