package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);
        one.next = two;
        two.next = three;
        three.next = four;
        new Main().deleteNode(two);
        System.out.println(one);
    }

    public void deleteNode(ListNode node) {
        ListNode pre = new ListNode(0);
        pre.next = node;
        while (node != null) {
            if (node.next != null) {
                node.val = node.next.val;
                node = node.next;
                pre = pre.next;
            } else {
                pre.next = null;
                node = null;
            }
        }
    }
}
