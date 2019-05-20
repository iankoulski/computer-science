package com.iankoulski.problems.ccibook.arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BasicStringCompressionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BasicStringCompressionTest( String testName )
    {
        super( testName );
        bsc = new BasicStringCompression();
    }

    private BasicStringCompression bsc;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BasicStringCompressionTest.class );
    }

    // test main
    public void testApp()
    {   
        String[] input1 = {"aabcccccddaaa"};
        com.iankoulski.problems.ccibook.arrays.BasicStringCompression.main(input1);
        assertTrue(true);
    }

    // Compressed string is shorter
    public void testShorter()
    {
        assertEquals(bsc.compressRepeatedChars("aabcccccddaaa"),"a2b1c5d2a3");
    }

    // Compressed string is longer
    public void testLonger()
    {
        String original = "abbcd";
        String result = bsc.compressRepeatedChars("abbcd");
        System.out.println("Original string: " + original);
        System.out.println("Compressed string: " + result);
        assertEquals(result, original);
    }

}
