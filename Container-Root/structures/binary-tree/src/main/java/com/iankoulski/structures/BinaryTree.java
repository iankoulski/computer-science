package com.iankoulski.structures;

import java.util.*;

/**
 * Binary Tree
 *
 */
public class BinaryTree 
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv Binary Tree Example vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n\n" );
		BinaryTreeNode root = makeSampleTree();
		System.out.println( "In-order traversal: ");
		System.out.println(toString(root));
		System.out.println( "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ End Binary Tree Example ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n" );
    }
	
	/**
	 * Create a text representation of a binary tree
	*/
	public static String toString( BinaryTreeNode root ){
		List<Integer> traversal = traverseInOrder(root);
		return traversal.toString();
	}

	private static List<Integer> traverseInOrder(BinaryTreeNode r){
		List<Integer> traversal = new ArrayList<>();
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(r);

		while (!s.isEmpty()){
			BinaryTreeNode n = s.peek();
			if (n.left!=null){
				s.push(n.left);
				n.left=null;
			}else{
				traversal.add(n.val);
				//n=n.right;
				s.pop();
				if (n.right!=null){
					s.push(n.right);
				}
			}
		}

		return traversal;
	}
	
	public static BinaryTreeNode makeSampleTree(){
		/*
				10
		       /  \
   		     20    30
		    /  \   /
		  40   50 60
		          /
				70
		*/

		BinaryTreeNode r = new BinaryTreeNode(10);
		BinaryTreeNode rl = new BinaryTreeNode(20);
		BinaryTreeNode rr = new BinaryTreeNode(30);
		BinaryTreeNode rll = new BinaryTreeNode(40);
		BinaryTreeNode rlr = new BinaryTreeNode(50);
		BinaryTreeNode rrl = new BinaryTreeNode(60);
		BinaryTreeNode rrll = new BinaryTreeNode(70);

		r.left = rl;
		r.right = rr;
		rl.left = rll;
		rl.right = rlr;
		rr.left = rrl;
		rrl.left = rrll;

		return r;
	}
}
