package com.iankoulski.problems.ccibook.tg;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class ListOfDepthsTest extends TestClass
{

    public ListOfDepthsTest()
    {
        super(ListOfDepthsTest.class);
        lod = new ListOfDepths();
    }

    private ListOfDepths lod;

    /**
     * @return the suite of tests being tested
     */
/*     public static Test suite()
    {
        return new TestSuite( ListOfDepthsTest.class );
    } */

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.ListOfDepths.main(null);
        Assert.assertTrue(true);
    }

    public BinaryTreeNode<Integer> getTestTree(){
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
        one.left=two;
        one.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;
        return one;
    }

    @Test
    public void testBreadthFirstSearch()
    {
        BinaryTreeNode<Integer> tree = getTestTree();
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = lod.getListOfDepthsBFS(tree);
        String strResult = listOfDepths.toString();
        Assert.assertEquals("[[1], [2, 3], [4, 5, 6, 7]]",strResult);
    }

    @Test
    public void testDepthFirstSearch()
    {
        BinaryTreeNode<Integer> tree = getTestTree();
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = lod.getListOfDepthsDFS(tree);
        String strResult = listOfDepths.toString();
        Assert.assertEquals("[[1], [2, 3], [4, 5, 6, 7]]",strResult);
    }

}
