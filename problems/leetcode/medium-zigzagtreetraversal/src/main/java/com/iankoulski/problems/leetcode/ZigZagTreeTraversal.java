package com.iankoulski.problems.leetcode;

import java.util.List;

/**
 * Traversal of binary tree in a zigzag pattern
 *
 */
public class ZigZagTreeTraversal 
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvvvvvv ZigZag Tree Traversal vvvvvvvvvvvvvvvvvvvvvvvv\n" );
		TreeNode root=makeSampleTree();
		ZigZagTreeTraversalSolution zztts = new ZigZagTreeTraversalSolution();
		System.out.println("Tree:");
		List<List<Integer>> zz = zztts.zigzagLevelOrder(root);
		System.out.println("\nTraversal:");
		System.out.println(zz);
		System.out.println( "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^ End ZigZag Tree Traversal ^^^^^^^^^^^^^^^^^^^^^^^\n");
    }
	
	public static TreeNode makeSampleTree(){
		TreeNode root = new TreeNode(3);
		TreeNode rl = new TreeNode(9);
		TreeNode rr = new TreeNode(20);
		root.left=rl;
		root.right=rr;
		TreeNode rrl = new TreeNode(15);
		TreeNode rrr = new TreeNode(7);
		rr.left=rrl;
		rr.right=rrr;
		return root;
	}
}
