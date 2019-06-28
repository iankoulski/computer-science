package com.iankoulski.problems.ccibook.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class BasicStringCompressionTest 
    extends TestClass
{
 
    public BasicStringCompressionTest()
    {
        super(BasicStringCompressionTest.class);
        bsc = new BasicStringCompression();
    }

    private BasicStringCompression bsc;

    // test main
    @Test
    public void testApp()
    {   
        String[] input1 = {"aabcccccddaaa"};
        com.iankoulski.problems.ccibook.arrays.BasicStringCompression.main(input1);
        Assert.assertTrue(true);
    }

    // Compressed string is shorter
    @Test
    public void testShorter()
    {
        Assert.assertEquals(bsc.compressRepeatedChars("aabcccccddaaa"),"a2b1c5d2a3");
    }

    // Compressed string is longer
    @Test
    public void testLonger()
    {
        String original = "abbcd";
        String result = bsc.compressRepeatedChars("abbcd");
        System.out.println("Original string: " + original);
        System.out.println("Compressed string: " + result);
        Assert.assertEquals(result, original);
    }

}
