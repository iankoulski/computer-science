package com.iankoulski.problems.ccibook.lists;

import org.junit.Test;
import org.junit.runners.model.TestClass;

import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class PartitionTest extends TestClass
{
    public PartitionTest( )
    {
        super( PartitionTest.class );
        p = new Partition();
    }

    private Partition p;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.lists.Partition.main(null);
        Assert.assertTrue(true);
    }

    // Input: 1->2->5->3->6->4
    @Test
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
        Assert.assertEquals("4->3->2->1->5->6",strResult);   
    }

}
