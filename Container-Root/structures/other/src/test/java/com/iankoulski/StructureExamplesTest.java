package com.iankoulski;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class StructureExamplesTest extends TestClass
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StructureExamplesTest()
    {
        super(StructureExamplesTest.class);
    }

    @Test    
    public void testApp()
    {
    	com.iankoulski.StructureExamples.main(null);
        Assert.assertTrue( true );
    }
}
