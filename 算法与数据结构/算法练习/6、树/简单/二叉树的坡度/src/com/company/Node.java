package com.company;

/**
 * @program: 二叉树的坡度
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-20 15:54
 **/
public class Node {

    int val;
    Node next;

    public Node() {
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
