package com.iankoulski.problems.ccibook.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class MatrixRotatorTest extends TestClass
{

    public MatrixRotatorTest()
    {
        super( MatrixRotatorTest.class );
        mr = new MatrixRotator();
    }

    private MatrixRotator mr;

    // test main
    @Test
    public void testApp()
    {   
        String[] args=null;
        com.iankoulski.problems.ccibook.arrays.MatrixRotator.main(args);
        Assert.assertTrue(true);
    }

    // Known Matrix
    @Test
    public void testKnownMatrix()
    {
        int[][] matrix = {{10,23,12,66,23},
                          {11,35,62,12,11},
                          {73,45,66,23,12},
                          {53,62,12,67,83},
                          {99,82,45,31,64}};
        Assert.assertTrue(mr.rotate(matrix));
        Assert.assertTrue(matrix[1][1] == 62);
    }

}
