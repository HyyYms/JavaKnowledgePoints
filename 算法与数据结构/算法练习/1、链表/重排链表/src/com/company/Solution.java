package com.company;

import java.util.List;

/**
 * @program: 重排链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-19 09:02
 **/
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }

        ListNode firstEndNode = endOfFirstHalf(head);
        ListNode secondStartNode = reverseList(firstEndNode.next);

        ListNode node1 = head;
        ListNode node2 = secondStartNode;
        ListNode p1 = node1;
        ListNode p2 = node2;

        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = node1;
            p2 = node2;
        }
        p1.next = null;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
