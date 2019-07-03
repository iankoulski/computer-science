package com.iankoulski.problems.ccibook.tg;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;
    public boolean visited;

    public BinaryTreeNode(T d){
        this.data=d;
    }

    public String toString(){
        return data.toString();
    }
}