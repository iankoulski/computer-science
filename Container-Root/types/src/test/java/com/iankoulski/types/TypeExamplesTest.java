package com.iankoulski.types;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class TypeExamplesTest extends TestClass
{
    public TypeExamplesTest( )
    {
        super( TypeExamplesTest.class );
    }

    @Test
    public void testApp()
    {
    	com.iankoulski.types.TypeExamples.main(null);
        Assert.assertTrue( true );
    }
}
