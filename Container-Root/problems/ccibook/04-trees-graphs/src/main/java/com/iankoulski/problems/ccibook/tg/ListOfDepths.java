package com.iankoulski.problems.ccibook.tg;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
Problem: 
Given a binary tree, create a linked list of all nodes at each depth.

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
{
    {5},
    {3,7},
    {2,4,6,8},
    {1,9}
}

Algo:
#1
Do a breadth-first search and create a linked list at each level. Add the linked lists to an array.

or

#2
Do a depth-first search. Keep track of the level for each element. Create a linked list for each level, 
dynamically add elements to the correct linked lists they get visited. 

*/

public class ListOfDepths {

    public static void main( String[] args ){
        System.out.println("\n=========================v List of Depths v======================\n");

        ListOfDepths lod = new ListOfDepths();
        BinaryTreeNode<Integer> bt = lod.getTestTree();
        System.out.println("Input: ");
        System.out.println("                  5        \n"   + 
                           "                /   \\     \n"   + 
                           "               3     7     \n"   + 
                           "              / \\   / \\  \n"   + 
                           "             2   4 6   8   \n"   + 
                           "            /           \\ \n"   + 
                           "           1             9 \n");


        System.out.println("\nOutput:");
        System.out.println("\nBreadth-first search:");
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepthsBFS = lod.getListOfDepthsBFS(bt);
        System.out.println("List of depths using modified breadth-first search: " + listOfDepthsBFS.toString());
        
        System.out.println("\nDepth-first search:");
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepthsDFS = lod.getListOfDepthsDFS(bt);
        System.out.println("List of depths using modified depth-first search: " + listOfDepthsDFS.toString());
    
        System.out.println("\n=========================^ List of Depths ^======================\n");
    }

    public ArrayList<LinkedList<BinaryTreeNode<Integer>>> getListOfDepthsBFS(BinaryTreeNode<Integer> bt) {
        if (bt==null) return null;
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();

        int level = 0;
        LinkedList<BinaryTreeNode<Integer>> parents = new LinkedList<BinaryTreeNode<Integer>>();
        parents.add(bt);
        
        while(parents.size()>0){
            System.out.println("Adding level " + level);
            listOfDepths.add(parents);
            LinkedList<BinaryTreeNode<Integer>> children = new LinkedList<BinaryTreeNode<Integer>>();
            for (BinaryTreeNode<Integer> parent : parents){
                if (parent.left != null) children.add(parent.left);
                if (parent.right != null) children.add(parent.right);
            }
            parents = children;
            level++;
        }
        return listOfDepths;
    }

    public ArrayList<LinkedList<BinaryTreeNode<Integer>>> getListOfDepthsDFS(BinaryTreeNode<Integer> bt) {
        if (bt==null) return null;
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
        createLevelLinkedList(bt,listOfDepths,0);
        return listOfDepths;
    }

    private void createLevelLinkedList(BinaryTreeNode<Integer> node,
            ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths, int level) {
        
        System.out.println("Adding node level " + level);
        LinkedList<BinaryTreeNode<Integer>> list = null;
        if (listOfDepths.size()<=level){
            list = new LinkedList<BinaryTreeNode<Integer>>();
            listOfDepths.add(list);
        }else{
            list = listOfDepths.get(level);
        }
        list.add(node);
        if (node.left!=null) createLevelLinkedList(node.left, listOfDepths, level + 1);
        if (node.right!=null) createLevelLinkedList(node.right, listOfDepths, level + 1);
    }

    public BinaryTreeNode<Integer> getTestTree() {
        
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> nine = new BinaryTreeNode<Integer>(9);
        five.left=three;
        five.right=seven;
        three.left=two;
        three.right=four;
        two.left=one;
        seven.left=six;
        seven.right=eight;
        eight.right=nine;

        return five;
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