package com.iankoulski;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StructureExamplesTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StructureExamplesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StructureExamplesTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	com.iankoulski.StructureExamples.main(null);
        assertTrue( true );
    }
}
