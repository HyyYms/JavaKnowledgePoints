package com.company;

import java.util.LinkedList;

/**
 * @program: 分隔链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 09:23
 **/
public class Solution {

    public ListNode partition2(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode minHead = new ListNode(0);
        ListNode maxHead = new ListNode(0);
        ListNode min = minHead;
        ListNode max = maxHead;

        while (cur != null) {
            if (cur.val < x) {
                min.next = cur;
                cur = cur.next;
                min = min.next;
                min.next = null;
            } else {
                max.next = cur;;
                cur = cur.next;
                max = max.next;
                max.next = null;
            }
        }

        min.next = maxHead.next;
        return minHead.next;
    }

    public ListNode partition1(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode minHead = new ListNode(0);
        ListNode maxHead = new ListNode(0);
        ListNode min = minHead;
        ListNode max = maxHead;

        while (cur != null) {
            if (cur.val < x) {
                min.next = new ListNode(cur.val);
                min = min.next;
            } else {
                max.next = new ListNode(cur.val);
                max = max.next;
            }
            cur = cur.next;
        }

        min.next = maxHead.next;
        return minHead.next;
    }
}
