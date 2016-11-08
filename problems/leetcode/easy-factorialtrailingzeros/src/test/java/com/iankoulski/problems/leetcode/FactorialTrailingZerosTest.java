package com.iankoulski.problems.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FactorialTrailingZerosTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FactorialTrailingZerosTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FactorialTrailingZerosTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	com.iankoulski.problems.leetcode.FactorialTrailingZeros.main(null);
        assertTrue( true );
    }
}
