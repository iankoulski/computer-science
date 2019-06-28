package com.iankoulski.structures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class BinaryTreeTest extends TestClass
{
    public BinaryTreeTest( )
    {
        super( BinaryTreeTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.structures.BinaryTree.main(null);
        Assert.assertTrue( true );
    }
}
