package com.iankoulski.problems.ccibook.tg;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class MinimalTreeTest extends TestClass
{

    public MinimalTreeTest( )
    {
        super( MinimalTreeTest.class );
        mt = new MinimalTree();
    }

    private MinimalTree mt;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.MinimalTree.main(null);
        Assert.assertTrue(true);
    }

    @Test
    public void testTraversal()
    {
        int[] array = new int[] {2,4,6,8,10,12,14,16,18,20,40,60,80,100};
        String strInput = Arrays.toString(array);
        System.out.println("Input: " + strInput);
        BinaryTreeNode<Integer> root = mt.buildBinarySearchTree(array);
        Assert.assertEquals(14,root.data.intValue());
        String strTraversal=mt.traverseInOrder(root).toString();
        System.out.println("In-order traversal of tree: " + strTraversal);
        Assert.assertEquals(strInput,strTraversal);   
    }

}
