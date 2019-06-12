package com.iankoulski.problems.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IntegerBreakTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IntegerBreakTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( IntegerBreakTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		com.iankoulski.problems.leetcode.IntegerBreak.main(new String[] {"16"});
		com.iankoulski.problems.leetcode.IntegerBreakSolution ibs = new com.iankoulski.problems.leetcode.IntegerBreakSolution();
		int v = ibs.integerBreak(16);
        assertTrue( v==324 );
    }
}
