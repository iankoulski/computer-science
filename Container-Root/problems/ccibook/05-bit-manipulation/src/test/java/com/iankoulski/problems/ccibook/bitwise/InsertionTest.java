package com.iankoulski.problems.ccibook.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class InsertionTest 
    extends TestClass
{
 
    public InsertionTest()
    {
        super(InsertionTest.class);
        ins = new Insertion();
    }

    private Insertion ins;

    // test main
    @Test
    public void testApp()
    {   
        com.iankoulski.problems.ccibook.bitwise.Insertion.main(null);
        Assert.assertTrue(true);
    }

    // Test number with 1 bits
    @Test
    public void testOnesImpl1()
    {
        int N = Integer.parseInt("10001010110",2);
        int M = Integer.parseInt("10001",2);
        int i=3,j=7;
        int result = ins.insertBits(N,M,i,j);
        String bitstr = Integer.toString(result,2);
        Assert.assertEquals("10010001110",bitstr);
    }

    // Test inserting to the edge
    @Test
    public void testEdgeImpl1()
    {
        int N = Integer.parseInt("10001000000",2);
        int M = Integer.parseInt("101",2);
        int i=0,j=2;
        int result = ins.insertBits(N,M,i,j);
        String bitstr = Integer.toString(result,2);
        Assert.assertEquals("10001000101",bitstr);
    }

    // Test number with 1 bits
    @Test
    public void testOnesImpl2()
    {
        int N = Integer.parseInt("10001010110",2);
        int M = Integer.parseInt("10001",2);
        int i=3,j=7;
        int result = ins.insertIntBits(N,M,i,j);
        String bitstr = Integer.toString(result,2);
        Assert.assertEquals("10010001110",bitstr);
    }

    // Test inserting to the edge
    @Test
    public void testEdgeImpl2()
    {
        int N = Integer.parseInt("10001000000",2);
        int M = Integer.parseInt("101",2);
        int i=0,j=2;
        int result = ins.insertIntBits(N,M,i,j);
        String bitstr = Integer.toString(result,2);
        Assert.assertEquals("10001000101",bitstr);
    }    

}
