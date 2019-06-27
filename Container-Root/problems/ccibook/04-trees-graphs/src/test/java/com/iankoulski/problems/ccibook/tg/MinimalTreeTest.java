package com.iankoulski.problems.ccibook.tg;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MinimalTreeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MinimalTreeTest( String testName )
    {
        super( testName );
        mt = new MinimalTree();
    }

    private MinimalTree mt;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MinimalTreeTest.class );
    }

    // test main
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.MinimalTree.main(null);
        assertTrue(true);
    }

    public void testTraversal()
    {
        int[] array = new int[] {2,4,6,8,10,12,14,16,18,20,40,60,80,100};
        String strInput = Arrays.toString(array);
        System.out.println("Input: " + strInput);
        BinaryTreeNode<Integer> root = mt.buildBinarySearchTree(array);
        assertEquals(14,root.data.intValue());
        String strTraversal=mt.traverseInOrder(root).toString();
        System.out.println("In-order traversal of tree: " + strTraversal);
        assertEquals(strInput,strTraversal);   
    }

}
