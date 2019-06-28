package com.iankoulski.problems.ccibook.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class DiffCheckerTest extends TestClass
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DiffCheckerTest( )
    {
        super( DiffCheckerTest.class );
        dc = new DiffChecker();
    }

    private DiffChecker dc;

    // test main
    @Test
    public void testApp()
    {   
        String[] input1 = {"pale","pales"};
        com.iankoulski.problems.ccibook.arrays.DiffChecker.main(input1);
        Assert.assertTrue(true);
    }

    // pale, ple -> true
    @Test
    public void testPalePle()
    {
        Assert.assertTrue(dc.isOneEditAway("pale","ple"));
    }

    // ple, pale -> true
    @Test
    public void testPlePale()
    {
        Assert.assertTrue(dc.isOneEditAway("ple","pale"));
    }    

    // pales, pale -> true
    @Test
    public void testPalesPale()
    {
        Assert.assertTrue(dc.isOneEditAway("pales","pale"));
    }    

    // pale, bale -> true
    @Test
    public void testPaleBale()
    {
        Assert.assertTrue(dc.isOneEditAway("pale","bale"));
    }       

    // pale, bake -> false
    @Test
    public void testPaleBake()
    {
        Assert.assertFalse(dc.isOneEditAway("pale","bake"));
    }    


}
