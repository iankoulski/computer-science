package com.iankoulski.problems.ccibook.tg;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class CheckBinarySearchTreeTest extends TestClass {

    public CheckBinarySearchTreeTest() {
        super(CheckBinarySearchTreeTest.class);
        checkBST = new CheckBinarySearchTree();
    }

    private CheckBinarySearchTree checkBST;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.CheckBalanced.main(null);
        Assert.assertTrue(true);
    }

    public BinaryTreeNode<Integer> getTestTree(boolean valid){
        /*
        valid == true

                 4
               /   \
              2     6
             / \   / \
            2   3 5   7


        valid == false
                 4
               /   \
              2     6
             / \     \
            1   3     6

        */
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> two2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> six2 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        if (valid){
            four.left=two;
            four.right=six;
            two.left=two2;
            two.right=three;
            six.left=five;
            six.right=seven;
        }else{
            four.left=two;
            four.right=six;
            two.left=one;
            two.right=three;
            six.right=six2;
        }
        return four;
    }

    @Test
    public void testValidBinarySearchTree()
    {
        BinaryTreeNode<Integer> tree = getTestTree(true);
        boolean valid = checkBST.isBinarySearchTree(tree);
        Assert.assertTrue(valid);
    }

    @Test
    public void testInvalidBinarySearchTree()
    {
        BinaryTreeNode<Integer> tree = getTestTree(false);
        boolean valid = checkBST.isBinarySearchTree(tree);
        Assert.assertFalse(valid);
    }

}
