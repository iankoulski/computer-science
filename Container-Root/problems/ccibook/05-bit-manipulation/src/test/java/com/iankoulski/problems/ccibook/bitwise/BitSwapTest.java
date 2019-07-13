package com.iankoulski.problems.ccibook.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class BitSwapTest 
    extends TestClass
{
 
    public BitSwapTest()
    {
        super(BitSwapTest.class);
        bitSwap = new BitSwap();
    }

    private BitSwap bitSwap;

    // test main
    @Test
    public void testApp()
    {   
        com.iankoulski.problems.ccibook.bitwise.BitSwap.main(null);
        Assert.assertTrue(true);
    }

    // Test bit swap
    @Test
    public void testBitSwap()
    {
        int N = Integer.parseInt("01010110",2);
        int M = Integer.parseInt("10101001",2);
        int result = bitSwap.swapBits(N);
        Assert.assertEquals(M,result);
    }

    // Test corner case 1
    @Test
    public void testCornerCase1()
    {
        int N = Integer.parseInt("11111111",2);
        int M = Integer.parseInt("11111111",2);
        int result = bitSwap.swapBits(N);
        Assert.assertEquals(M,result);
    }

    // Test corner case 2
    @Test
    public void testCornerCase2()
    {
        int N = Integer.parseInt("00000000",2);
        int M = Integer.parseInt("00000000",2);
        int result = bitSwap.swapBits(N);
        Assert.assertEquals(M,result);
    }
    
}
