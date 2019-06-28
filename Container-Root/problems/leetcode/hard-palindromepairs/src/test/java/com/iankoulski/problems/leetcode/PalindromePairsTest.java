package com.iankoulski.problems.leetcode;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class PalindromePairsTest extends TestClass
{

    public PalindromePairsTest( )
    {
        super( PalindromePairsTest.class );
    }

    @Test
    public void testApp()
    {
		String[] words = new String[] {"tab","bat","lls","sssll"};
		com.iankoulski.problems.leetcode.PalindromePairs.main(words);
		PalindromePairsSolution pps = new PalindromePairsSolution();
		List<List<Integer>> pp = pps.palindromePairs(words);
        Assert.assertTrue( "[[0, 1], [1, 0], [2, 3]]".equals(pp.toString()) );
    }
}
