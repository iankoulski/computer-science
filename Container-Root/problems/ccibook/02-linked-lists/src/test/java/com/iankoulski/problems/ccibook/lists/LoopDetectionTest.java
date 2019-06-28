package com.iankoulski.problems.ccibook.lists;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class LoopDetectionTest extends TestClass
{
    public LoopDetectionTest( )
    {
        super( LoopDetectionTest.class);
        ld = new LoopDetection();
    }

    private LoopDetection ld;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.lists.LoopDetection.main(null);
        Assert.assertTrue(true);
    }

    Node getLinkedListWithLoop(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        Node n8=new Node(8);
        Node n9=new Node(9);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=n4;

        return n1;
    } 

    // Input: 1->2->3->4->5->6->7->8->9->4
    @Test
    public void testLoopDetectionByHash()
    {
        Node n = getLinkedListWithLoop();
        Node result = ld.findLoopByHash(n);
        Assert.assertEquals(4,result.data);   
    }

    @Test
    public void testLoopDetectionByRunner(){
        Node n = getLinkedListWithLoop();
        Node result = ld.findLoopByRunner(n);
        Assert.assertEquals(4,result.data);
    }

}
