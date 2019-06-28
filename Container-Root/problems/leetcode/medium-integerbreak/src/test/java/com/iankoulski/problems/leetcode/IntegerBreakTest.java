package com.iankoulski.problems.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class IntegerBreakTest extends TestClass
{
    public IntegerBreakTest( )
    {
        super( IntegerBreakTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.problems.leetcode.IntegerBreak.main(new String[] {"16"});
		com.iankoulski.problems.leetcode.IntegerBreakSolution ibs = new com.iankoulski.problems.leetcode.IntegerBreakSolution();
		int v = ibs.integerBreak(16);
        Assert.assertTrue( v==324 );
    }
}
