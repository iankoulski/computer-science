package com.iankoulski.problems.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class ReverseVowelsTest extends TestClass
{

    public ReverseVowelsTest( )
    {
        super( ReverseVowelsTest.class );
    }

    @Test
    public void testApp()
    {
		com.iankoulski.problems.leetcode.ReverseVowels.main(new String[] {"This is a test"});
		com.iankoulski.problems.leetcode.ReverseVowels rv = new com.iankoulski.problems.leetcode.ReverseVowels();
		String rvs = rv.getSolution().reverseVowels("This is a test");
        Assert.assertTrue( "Thes as i tist".equals(rvs) );
    }
}
