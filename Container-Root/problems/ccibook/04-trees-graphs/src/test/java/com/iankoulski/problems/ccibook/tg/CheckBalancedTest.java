package com.iankoulski.problems.ccibook.tg;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class CheckBalancedTest extends TestClass
{

    public CheckBalancedTest()
    {
        super(CheckBalancedTest.class);
        cb = new CheckBalanced();
    }

    private CheckBalanced cb;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.CheckBalanced.main(null);
        Assert.assertTrue(true);
    }

    public BinaryTreeNode<Integer> getTestTree(boolean balanced){
        /*
        balanced == true

                 1
               /   \
              2     3
             / \   / 
            4   5 6   


        balanced == false
                 1
               /   \
              2     3
             /     / 
            4     6   
           /
          5

        */
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        if (balanced){
            one.left=two;
            one.right=three;
            two.left=four;
            two.right=five;
            three.left=six;
        }else{
            one.left=two;
            one.right=three;
            three.left=six;
            two.left=four;
            four.left=five;
        }
        return one;
    }

    @Test
    public void testBalancedTree()
    {
        BinaryTreeNode<Integer> tree = getTestTree(true);
        boolean balanced = cb.isBalanced(tree);
        Assert.assertTrue(balanced);
    }

    @Test
    public void testImbalancedTree()
    {
        BinaryTreeNode<Integer> tree = getTestTree(false);
        boolean balanced = cb.isBalanced(tree);
        Assert.assertFalse(balanced);
    }

}
