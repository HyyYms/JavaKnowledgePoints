package com.company.first;

import com.company.ListNode;

/**
 * @program: 反转链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 17:35
 **/
public class Solution {
//    反转一个单链表。
//
//    示例:
//
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL
//    进阶:
//    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
