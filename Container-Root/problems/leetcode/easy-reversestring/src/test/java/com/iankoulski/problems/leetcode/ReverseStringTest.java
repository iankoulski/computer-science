package com.iankoulski.problems.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ReverseStringTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseStringTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReverseStringTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		com.iankoulski.problems.leetcode.ReverseString.main(new String[] {"This is a test"});
        assertTrue( true );
    }
}
