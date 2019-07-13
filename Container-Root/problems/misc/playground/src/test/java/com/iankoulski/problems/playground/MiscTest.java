package com.iankoulski.problems.playground;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class MiscTest extends TestClass
{

    public MiscTest( )
    {
        super( MiscTest.class );
    }

    @Test
    public void testApp()
    {
    	com.iankoulski.problems.playground.Misc.main(null);
        Assert.assertTrue( true );
    }

    @Test
    public void testHello(){
        Misc m = new Misc();
        String hello = m.sayHello("Alex");
        Assert.assertEquals("Hello, Alex!",hello);
    }


}
