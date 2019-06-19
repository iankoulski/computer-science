package com.iankoulski.problems.ccibook.lists;

/* 2.4 Partition
Write code to partition a linked list around a value x, such that all nodes less than x 
come before all nodes greater than or equal to x. If x is contained within the list, 
the values of x only need to be after the elements less than x. 
The partition element x can appear anywhere in the “right partition”; 
it does not need to appear between the left and the right partitions.

EXAMPLE:
input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

/* Algo
Use two pointers, one always points to the beginning, and one moves to next element 
until it finds an element less than the pivot, then inserts it in the beginning.
Solution provided using singly-linked list

Space complexity: O(1)
Time complexity: O(n)
*/

/*
Partition Example:
3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
first = 3
current = 3
next = 5
(5<5)== false
current = 5
next = 8
(8<5)==false
current=8
next=5
(5<5)==false
current = 5
next = 10
(10<5) == false
current = 10
next = 2
(2<5) == true
current.next = next.next = 1
next.next = first.next = 3
first = 2
2->3 -> 5 -> 8 -> 5 -> 10 -> 1
current = 10
next = 1
(1<5) == true
current.next = null
next.next = 2
first = 1
1->2->3 -> 5 -> 8 -> 5 -> 10
next = null
return first
*/

class Node {
    Node next = null;
	int data;
    
    public Node(int d){
		data = d;
	}

}

class Partition {

    public static void main(String[] args){
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(5);
        Node n5 = new Node(10);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        Partition p = new Partition();
        Node result = p.partition(n1,5);
        System.out.println(p.toString(result));
    }

    Node partition(Node node, int x){
        Node first=node;
        Node current=first;
        Node next=first.next;
        while (next != null) {
            if (next.data < x){
                // move node to beginning of list
                current.next = next.next;
                next.next=first;
                first=next;
            }else{
            current = current.next;
            }
            next = current.next;
        }
        return first;
    }

    public String toString(Node n){
        StringBuilder sb = new StringBuilder();
        while (n != null){
            sb.append(n.data);
            if (n.next != null) sb.append("->");
            n=n.next;
        }
        return sb.toString();
    }    
}