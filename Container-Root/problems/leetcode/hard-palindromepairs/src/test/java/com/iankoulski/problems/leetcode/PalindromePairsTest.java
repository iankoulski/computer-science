package com.iankoulski.problems.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class PalindromePairsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PalindromePairsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PalindromePairsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		String[] words = new String[] {"tab","bat","lls","sssll"};
		com.iankoulski.problems.leetcode.PalindromePairs.main(words);
		PalindromePairsSolution pps = new PalindromePairsSolution();
		List<List<Integer>> pp = pps.palindromePairs(words);
        assertTrue( "[[0, 1], [1, 0], [2, 3]]".equals(pp.toString()) );
    }
}
