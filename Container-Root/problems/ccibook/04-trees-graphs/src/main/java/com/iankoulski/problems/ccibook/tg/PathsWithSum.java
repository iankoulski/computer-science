package com.iankoulski.problems.ccibook.tg;

import java.util.Hashtable;

/*
Problem:
Each node in a binary tree is an integer value (positive or negative). Count the number of paths
in the tree that sum to a given value. The path does not need to start or end at the root or a leaf, 
but it must go only from parent nodes to child nodes. 

Example:
Input:
                 10
                /  \
               5   -3
              / \    \
             3   2    1
            / \   \       
           3  -2   1    

Target Sum: 8

Output: 3 <- (5,3); (5,2,1); (10,-3,1)
 
Algo:
#1
Depth-first search. At each step check if running sum == target sum and increment count.

#2
Depth-first search. Build counts of paths for each encountered sum in hash table, return count paths for target sum.
*/

public class PathsWithSum {

    public static void main(String[] args) {
        System.out.println("\n=========================v Paths with Sum v======================\n");

        PathsWithSum pws = new PathsWithSum();

        System.out.println("Input: Binary tree");
        BinaryTreeNode<Integer> testTree = pws.getTestTree();

        int countSums = pws.countSums1(testTree,8);
        System.out.println("Output (Algo #1): " + countSums);

        countSums = pws.countSums2(testTree,8);
        System.out.println("Output (Algo#2): " + countSums);

        System.out.println("\n=========================^ Paths with Sum ^======================\n");
    }


    // Recursive Brute Force - Traverse in order and for each node traverse each subtree
    // Runtime complexity is O(N log N), N - number of nodes in the tree for a balanced tree. Worst case O(N2) - unbalanced tree
    // Space complexity is also O(N log N) because the call stack creates a new int count at each recursion.
    public int countSums1(BinaryTreeNode<Integer> node, int targetSum){
        if (node == null) return 0;
        int count = 0;
        count = countSums1(node,targetSum,0);
        count += countSums1(node.left,targetSum);
        count += countSums1(node.right,targetSum);
        return count;
    }

    private int countSums1( BinaryTreeNode<Integer> node, int targetSum, int runningSum ){
        if (node==null) return 0;
        int count = 0;
        runningSum = runningSum + node.data;
        if (runningSum == targetSum) count++;
        count += countSums1(node.left,targetSum,runningSum);
        count += countSums1(node.right,targetSum,runningSum);
        return count;
    }

    // Recursive with running sums and Hash Table
    // Time: O(N) because we visit each node only once
    // Space: O(log N) - average, O(N) - worst case
    public int countSums2(BinaryTreeNode<Integer> node, int targetSum) {
        if (node==null) return 0;
        int runningSum = 0;
        Hashtable<Integer,Integer> pathCount = new Hashtable<Integer,Integer>();
        int count = countSums2(node, targetSum, runningSum, pathCount);
        return count;
    }

    public int  countSums2(BinaryTreeNode<Integer> node, int targetSum, int runningSum, 
            Hashtable<Integer, Integer> pathCount) {
        if (node==null) return 0;
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int pathCnt = pathCount.getOrDefault(sum,0);
        if (sum==0) pathCnt++;
        updateCount(pathCount,runningSum,1);
        pathCnt += countSums2(node.left,targetSum,runningSum,pathCount);
        pathCnt += countSums2(node.right,targetSum,runningSum,pathCount);
        updateCount(pathCount,runningSum,-1);
        return pathCnt;
    }

    void updateCount(Hashtable<Integer,Integer> pathCount, int key, int delta){
        int count = pathCount.getOrDefault(key, 0);
        count += delta;
        if (count<=0) pathCount.remove(key);
        else pathCount.put(key,count);
    }

    public BinaryTreeNode<Integer> getTestTree() {
        
        BinaryTreeNode<Integer> ten = new BinaryTreeNode<Integer>(10);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> three2 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> mtwo = new BinaryTreeNode<Integer>(-2);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> mthree = new BinaryTreeNode<Integer>(-3);
        BinaryTreeNode<Integer> one2 = new BinaryTreeNode<Integer>(1);
        ten.left=five;
        ten.right=mthree;
        five.left=three;
        five.right=two;
        three.left=three2;
        three.right=mtwo;
        two.right=one;
        mthree.right=one2;
        return ten;
    }
    
}