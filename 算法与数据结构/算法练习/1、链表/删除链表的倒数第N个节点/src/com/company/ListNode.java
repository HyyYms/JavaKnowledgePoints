package com.company;

/**
 * @program: 删除链表的倒数第N个节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-16 10:47
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
