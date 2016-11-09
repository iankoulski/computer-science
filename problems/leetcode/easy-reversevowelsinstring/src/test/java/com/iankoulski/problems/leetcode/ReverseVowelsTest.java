package com.iankoulski.problems.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ReverseVowelsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseVowelsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReverseVowelsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		com.iankoulski.problems.leetcode.ReverseVowels.main(new String[] {"This is a test"});
		com.iankoulski.problems.leetcode.ReverseVowels rv = new com.iankoulski.problems.leetcode.ReverseVowels();
		String rvs = rv.getSolution().reverseVowels("This is a test");
        assertTrue( "Thes as i tist".equals(rvs) );
    }
}
