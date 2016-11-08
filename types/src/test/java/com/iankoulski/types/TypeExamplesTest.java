package com.iankoulski.types;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TypeExamplesTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TypeExamplesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TypeExamplesTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	com.iankoulski.types.TypeExamples.main(null);
        assertTrue( true );
    }
}
