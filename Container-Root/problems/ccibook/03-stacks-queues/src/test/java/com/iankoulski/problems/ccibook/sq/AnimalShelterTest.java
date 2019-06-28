package com.iankoulski.problems.ccibook.sq;

import com.iankoulski.problems.ccibook.sq.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class AnimalShelterTest extends TestClass
{

    public AnimalShelterTest( )
    {
        super( AnimalShelterTest.class );
    }

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.sq.AnimalShelter.main(null);
        Assert.assertTrue(true);
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
    @Test
    public void testDequeueAny()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueAny();
        Assert.assertEquals("Kit", a.toString());
    }

    // dequeueCat should return the Cat that got in the shelter first -> Kit
    @Test
    public void testDequeueCat()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueCat();
        Assert.assertEquals("Kit", a.toString());
    }

    // dequeueDog should return the Dog that got in the shelter first -> Ruf
    @Test
    public void testDequeueDog()
    {
        AnimalShelter shelter = getTestShelter();
        Animal a = shelter.dequeueDog();
        Assert.assertEquals("Ruf", a.toString());
    }

}
