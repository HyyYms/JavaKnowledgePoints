package com.company;

/**
 * @program: 两个链表的第一个公共节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-16 19:19
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
