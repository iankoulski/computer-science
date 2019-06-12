package com.iankoulski.structures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BinaryTreeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinaryTreeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BinaryTreeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		com.iankoulski.structures.BinaryTree.main(null);
        assertTrue( true );
    }
}
