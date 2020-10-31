package com.company;

/**
 * @program: 复制带随机指针的链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 22:26
 **/
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
