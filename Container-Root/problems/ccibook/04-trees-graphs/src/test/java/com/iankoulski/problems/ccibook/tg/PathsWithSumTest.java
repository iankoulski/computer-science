package com.iankoulski.problems.ccibook.tg;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class PathsWithSumTest extends TestClass
{

    public PathsWithSumTest()
    {
        super(PathsWithSumTest.class);
        pws = new PathsWithSum();
    }

    private PathsWithSum pws;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.PathsWithSum.main(null);
        Assert.assertTrue(true);
    }

    public BinaryTreeNode<Integer> getTestTree(int id){
        /*
        id == 1

                 1
               /   \
              1     3
             / \   / \
            4   5 6  -2
           / \
         -4   6

        id == 2
                 10
               /    \
              2      5
             /      / \
            4     -6   1
           / \      \   \
          5   2      7   16

        */
        BinaryTreeNode<Integer> root = null;
        BinaryTreeNode<Integer> one1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> one2 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two1 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> two2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five1 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> five2 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six1 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> six2 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> m2 = new BinaryTreeNode<Integer>(-2);
        BinaryTreeNode<Integer> m4 = new BinaryTreeNode<Integer>(-4);
        BinaryTreeNode<Integer> m6 = new BinaryTreeNode<Integer>(-6);
        BinaryTreeNode<Integer> ten = new BinaryTreeNode<Integer>(10);
        BinaryTreeNode<Integer> sixteen = new BinaryTreeNode<Integer>(16);

        switch (id){
            case 1:
                root = one1;
                one1.left = one2;
                one1.right=three;
                one2.left = four;
                one2.right = five1;
                four.left = m4;
                four.right=six1;
                three.left=six2;
                three.right=m2;
                break;
            case 2:
                root=ten;
                ten.left=two1;
                ten.right=five1;
                two1.left=four;
                four.left=five2;
                four.right=two2;
                five1.left=m6;
                five1.right=one1;
                one1.right=sixteen;
                m6.right=seven;
                break;
            default:
                root = null;
        }

        return root;
    }

    @Test
    public void testTreeOneAlgo1()
    {
        BinaryTreeNode<Integer> tree = getTestTree(1);
        int count = pws.countSums1(tree,2);
        Assert.assertEquals(3,count);
    }

    @Test
    public void testTreeOneAlgo2()
    {
        BinaryTreeNode<Integer> tree = getTestTree(1);
        int count = pws.countSums2(tree,2);
        Assert.assertEquals(3,count);
    }

    @Test
    public void testTreeTwoAlgo1()
    {
        BinaryTreeNode<Integer> tree = getTestTree(2);
        int count = pws.countSums1(tree,16);
        Assert.assertEquals(4,count);
    }

    @Test
    public void testTreeTwoAlgo2()
    {
        BinaryTreeNode<Integer> tree = getTestTree(2);
        int count = pws.countSums2(tree,16);
        Assert.assertEquals(4,count);
    }

}
