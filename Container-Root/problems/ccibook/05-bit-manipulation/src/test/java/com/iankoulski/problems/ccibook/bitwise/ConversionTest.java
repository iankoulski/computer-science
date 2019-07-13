package com.iankoulski.problems.ccibook.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class ConversionTest 
    extends TestClass
{
 
    public ConversionTest()
    {
        super(ConversionTest.class);
        conv = new Conversion();
    }

    private Conversion conv;

    // test main
    @Test
    public void testApp()
    {   
        com.iankoulski.problems.ccibook.bitwise.Conversion.main(null);
        Assert.assertTrue(true);
    }

    // Test numbers different with 2 bits
    @Test
    public void testConversion()
    {
        int N = Integer.parseInt("1010110",2);
        int M = Integer.parseInt("1010101",2);
        int result = conv.countBitFlips(N,M);
        Assert.assertEquals(2,result);
    }

    // Test same numbers
    @Test
    public void testNoConversion()
    {
        int N = Integer.parseInt("10001000",2);
        int M = Integer.parseInt("10001000",2);
        int result = conv.countBitFlips(N,M);
        Assert.assertEquals(result,0);
    }

}
