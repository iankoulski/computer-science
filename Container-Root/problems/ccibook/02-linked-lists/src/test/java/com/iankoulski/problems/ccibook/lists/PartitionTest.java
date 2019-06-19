package com.iankoulski.problems.ccibook.lists;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PartitionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PartitionTest( String testName )
    {
        super( testName );
        p = new Partition();
    }

    private Partition p;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PartitionTest.class );
    }

    // test main
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.lists.Partition.main(null);
        assertTrue(true);
    }

    // Input: 1->2->5->3->6->4
    public void testPartition()
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(3);
        Node n5 = new Node(6);
        Node n6 = new Node(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        Partition p = new Partition();
        Node result = p.partition(n1,5);
        String strResult = p.toString(result);
        System.out.println("Input: 1->2->5->3->6->4");
        System.out.println("Output: " + strResult); 
        assertEquals("4->3->2->1->5->6",strResult);   
    }

}
