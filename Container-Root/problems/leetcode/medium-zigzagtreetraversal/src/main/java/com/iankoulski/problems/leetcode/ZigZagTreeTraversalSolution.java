package com.iankoulski.problems.leetcode;

import java.util.*;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ZigZagTreeTraversalSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Result list
        List<List<Integer>> list = new LinkedList<>();

        // Queue for current level nodes
        Queue<TreeNode> q = new LinkedList<>();

        // Queue for next level nodes
        Queue<TreeNode> qn = new LinkedList<>();

        // Direction indicator
        int direction = 1;

        if (root != null) {

            // Current level list
            List<Integer> l = new LinkedList<>();

            // Always start from root
            q.add(root);

            while (!q.isEmpty()) {

                // Add node from current level to list
                TreeNode n = q.remove();
                System.out.println(n.val);
                l.add(n.val);

                // Add child nodes to next queue
                if (n.left!=null) qn.add(n.left);
                if (n.right!=null) qn.add(n.right);

                // If no more nodes on current level
                if (q.isEmpty()){
                    // Add level list to result using correct direction
                    if (direction < 0){
                        Collections.reverse(l);
                    }
                    list.add(l);
                    direction *= -1;

                    // Switch to next level (rinse and repeat ;)
                    q = qn;
                    l = new LinkedList<>();
                    qn = new LinkedList<>();
                }
            }
        }else{
            System.out.println("Empty tree");
        }
        return list;
    }
}