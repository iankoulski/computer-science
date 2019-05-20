package com.iankoulski.problems.ccibook.arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DiffCheckerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DiffCheckerTest( String testName )
    {
        super( testName );
        dc = new DiffChecker();
    }

    private DiffChecker dc;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DiffCheckerTest.class );
    }

    // test main
    public void testApp()
    {   
        String[] input1 = {"pale","pales"};
        com.iankoulski.problems.ccibook.arrays.DiffChecker.main(input1);
        assertTrue(true);
    }

    // pale, ple -> true
    public void testPalePle()
    {
        assertTrue(dc.isOneEditAway("pale","ple"));
    }

    // ple, pale -> true
    public void testPlePale()
    {
        assertTrue(dc.isOneEditAway("ple","pale"));
    }    

    // pales, pale -> true
    public void testPalesPale()
    {
        assertTrue(dc.isOneEditAway("pales","pale"));
    }    

    // pale, bale -> true
    public void testPaleBale()
    {
        assertTrue(dc.isOneEditAway("pale","bale"));
    }       

    // pale, bake -> false
    public void testPaleBake()
    {
        assertFalse(dc.isOneEditAway("pale","bake"));
    }    


}
