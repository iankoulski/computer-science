package com.iankoulski.problems.hackerrank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class CountTripletsTest extends TestClass
{
    public CountTripletsTest( )
    {
        super( CountTripletsTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.problems.hackerrank.CountTriplets.main(null);
        Assert.assertTrue( true );
    }

    @Test
    public void testSixR3(){
        List<Long> arr = new ArrayList<Long>(Arrays.asList(new Long[] {new Long(1), new Long(3),
                                                                       new Long(9), new Long(9),
                                                                       new Long(27), new Long(81)}));
        CountTriplets ct = new CountTriplets();
        long triplets = ct.countTriplets(arr, 3);
        Assert.assertEquals(6,triplets);                                                               
    }
}
