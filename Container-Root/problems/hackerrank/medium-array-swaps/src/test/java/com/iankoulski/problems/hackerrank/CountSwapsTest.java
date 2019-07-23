package com.iankoulski.problems.hackerrank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class CountSwapsTest extends TestClass
{
    public CountSwapsTest( )
    {
        super( CountSwapsTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.problems.hackerrank.CountSwaps.main(null);
        Assert.assertTrue( true );
    }

    @Test
    public void testThreeSwaps(){
        CountSwaps cs = new CountSwaps();
        int[] arr = new int[] {2, 3, 4, 1, 5};
        int swaps = cs.minimumSwaps(arr);
        Assert.assertEquals(3,swaps);
    }
}
