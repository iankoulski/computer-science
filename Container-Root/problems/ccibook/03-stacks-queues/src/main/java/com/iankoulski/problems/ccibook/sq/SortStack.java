package com.iankoulski.problems.ccibook.sq;

/*
Sort a stack such that the smallest items are on the top. You may use an additional temporary stack, 
but you may not copy the elements into any other data structure.

Example:
Input: 3->1->2->8->6->2
Output: 1->2->2->3->6->8

Algo:
Use temp stack that that is "sorted" from highest to lowest number.
Pop number from stack and store it in a temp variable, then place in the "right" place in the temp stack.
To insert in the right place if necessary pop elements from temp and push into stack.

stack: 1->2->2->3->6->8
*/

public class SortStack {

    public static void main( String[] args ){
        System.out.println("=========================v Sort Stack v======================");
        Node<Integer> n1=new Node<Integer>(3);
        Node<Integer> n2=new Node<Integer>(1);
        Node<Integer> n3=new Node<Integer>(2);
        Node<Integer> n4=new Node<Integer>(8);
        Node<Integer> n5=new Node<Integer>(6);
        Node<Integer> n6=new Node<Integer>(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;   
        SortStack ss = new SortStack();
        Stack<Integer> stack = new Stack<Integer>(n1);
        System.out.println("Input: " + stack.getString());
        Stack<Integer> sorted_stack = ss.sortStack(stack);
        System.out.println("Output: " + sorted_stack.getString());
        System.out.println("=========================^ Sort Stack ^======================");
    }

    // Time O(n^2), Space O(n)
    Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> tmp = new Stack<Integer>();
        Integer v1=null,v2=null;  
        // Sort numbers into tmp      
        while (!stack.isEmpty()){
            if (v1==null) v1=stack.pop();
            while (!tmp.isEmpty()){
                v2=tmp.peek();
                if (v2>v1) stack.push(tmp.pop());
                else break;
            }
            tmp.push(v1);
            v1=null;
        }
        // Move/order numbers into stack
        while(!tmp.isEmpty()) stack.push(tmp.pop());
        return stack;
    }

}