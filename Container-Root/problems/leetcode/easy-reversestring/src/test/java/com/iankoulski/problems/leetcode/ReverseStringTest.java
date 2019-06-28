package com.iankoulski.problems.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class ReverseStringTest extends TestClass
{
    public ReverseStringTest( )
    {
        super( ReverseStringTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.problems.leetcode.ReverseString.main(new String[] {"This is a test"});
        Assert.assertTrue( true );
    }
}
