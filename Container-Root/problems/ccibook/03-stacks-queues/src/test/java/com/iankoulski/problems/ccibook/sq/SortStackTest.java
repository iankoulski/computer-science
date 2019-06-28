package com.iankoulski.problems.ccibook.sq;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class SortStackTest extends TestClass
{
    public SortStackTest()
    {
        super( SortStackTest.class );
        ss = new SortStack();
    }

    private SortStack ss;

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.sq.SortStack.main(null);
        Assert.assertTrue(true);
    }

    Stack<Integer> getTestStack(){
        Node<Integer> n1=new Node<Integer>(10);
        Node<Integer> n2=new Node<Integer>(4);
        Node<Integer> n3=new Node<Integer>(21);
        Node<Integer> n4=new Node<Integer>(15);
        Node<Integer> n5=new Node<Integer>(3);
        Node<Integer> n6=new Node<Integer>(8);
        Node<Integer> n7=new Node<Integer>(7);
        Node<Integer> n8=new Node<Integer>(6);
        Node<Integer> n9=new Node<Integer>(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=null;

        return new Stack<Integer>(n1);
    } 

    @Test
    public void testStackSorting()
    {
        Stack<Integer> s = getTestStack();
        System.out.println("Input: " + s.getString());
        Stack<Integer> result = ss.sortStack(s);
        String strResult=result.getString();
        System.out.println("Output: " + strResult);
        Assert.assertEquals("3->3->4->6->7->8->10->15->21",strResult);   
    }

}
