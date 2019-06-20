package com.iankoulski.problems.ccibook.lists;

class Node {
	Node next=null;
    int data;
    public Node(int d){
        data=d;
    }
	public Node(int d, Node n){
		data=d;
		next=n;
    }
}
