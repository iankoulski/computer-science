package com.iankoulski.problems.ccibook.lists;

import java.util.Hashtable;

/*
Loop Detection
Given a cirlular linked list, create an algorithm that returns the node at the beginning of the loop.

DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.

EXAMPLE
Input: A->B->C->D->E->C
Output: C

1->2->3->4->5->6->7->8->9->?

Algo
#1 
Build hash table as traversing list. Check if key exists for each element.

#2
Use slow/fast runner pattern and keep checking for null, detect collision. If it occurs, then there is a loop.
Move slow pointer to head and then move both pointers at the same pace forward until they collide. That is the beginning of the loop.

1->2->3->4->5->6->7->8->9->4, loop 4 == 9.next

//init
head=1
slow=1
fast=1

// corner case
if slow.next == slow, return slow

//loop
slow=2
fast=3
slow!=fast

slow=3
fast=5
slow!=fast

slow=4
fast=7
slow!=fast

slow=5
fast=9
slow!=fast

slow=6
fast=5
slow!=fast

slow=7
fast=7
slow=fast
// Loop exists

// Find loop start
slow=1
fast=7

slow=2
fast=8
slow!=fast

slow=3
fast=9
slow!=fast

slow=4
fast=4
slow==fast
// return 4 - beginning of loop
*/

public class LoopDetection {

    public static void main( String[] args ){
        System.out.println("=========================v Loop Detection v======================");
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
        LoopDetection ld = new LoopDetection();
        Node loop = ld.findLoopByHash(n1);
        System.out.println("Loop by hash: " + loop.data);
        loop = ld.findLoopByRunner(n1);
        System.out.println("Loop by runner: " + loop.data);
        System.out.println("=========================^ Loop Detection ^======================");
    }

    // #1 - Hashtable
    // Hashtable search is O(1) time, so this algo should be O(n) where n is the length of the list
    // Space complexity is also O(n) because we create an additional hashtable 
    Node findLoopByHash(Node n){
    Hashtable<Node,Integer> nodes = new Hashtable<Node,Integer>();
    while (n.next != null){
        if (nodes.containsKey(n)) break;
        nodes.put(n,1);
        n=n.next;
    }
    if (n.next != null) return n;
    return null;
    }


    //#2 Runner pattern
    // Time complexity should be O(n) and space complexity is O(1) since we don’t use extra space
    Node findLoopByRunner(Node n){
        Node head=n,slow=n,fast=n;
        
        if (slow == slow.next) return slow;        

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) break;
        }
        if (fast==null || fast.next==null) return null; // no loop

        slow=head;
        while (slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}