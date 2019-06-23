package com.iankoulski.problems.ccibook.sq;

import com.iankoulski.problems.ccibook.sq.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AnimalShelterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AnimalShelterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AnimalShelterTest.class );
    }

    // test main
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.sq.AnimalShelter.main(null);
        assertTrue(true);
    }

    // Test Data
    public AnimalShelter getTestShelter(){
        AnimalShelter shelter = new AnimalShelter();
        Cat kit = new Cat("Kit");
        shelter.enqueue(kit);
        Dog ruf = new Dog("Ruf");
        shelter.enqueue(ruf);
        Dog bob = new Dog("Bob");
        shelter.enqueue(bob);
        Cat sally = new Cat("Sally");
        shelter.enqueue(sally);
        return shelter;
    }

    // dequeueAny should return the animal that got in the shelter first -> Kit
    public void testDequeueAny()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueAny();
        assertEquals("Kit", a.toString());
    }

    // dequeueCat should return the Cat that got in the shelter first -> Kit
    public void testDequeueCat()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueCat();
        assertEquals("Kit", a.toString());
    }

    // dequeueDog should return the Dog that got in the shelter first -> Ruf
    public void testDequeueDog()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueDog();
        assertEquals("Ruf", a.toString());
    }

}
