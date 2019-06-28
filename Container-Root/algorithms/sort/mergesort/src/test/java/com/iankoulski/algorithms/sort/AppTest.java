package com.iankoulski.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestClass
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest()
    {
        super( AppTest.class );
    }

    @Test
    public void testApp()
    {
        com.iankoulski.algorithms.sort.MergeSortExample.main(null);
        Assert.assertTrue( true );
    }
}
