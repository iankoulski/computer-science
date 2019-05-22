package com.iankoulski.problems.ccibook.arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MatrixRotatorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatrixRotatorTest( String testName )
    {
        super( testName );
        mr = new MatrixRotator();
    }

    private MatrixRotator mr;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatrixRotatorTest.class );
    }

    // test main
    public void testApp()
    {   
        String[] args=null;
        com.iankoulski.problems.ccibook.arrays.MatrixRotator.main(args);
        assertTrue(true);
    }

    // Known Matrix
    public void testKnownMatrix()
    {
        int[][] matrix = {{10,23,12,66,23},
                          {11,35,62,12,11},
                          {73,45,66,23,12},
                          {53,62,12,67,83},
                          {99,82,45,31,64}};
        assertTrue(mr.rotate(matrix));
        assertTrue(matrix[1][1] == 62);
    }

}
