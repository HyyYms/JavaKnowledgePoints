package com.company;

/**
 * @program: 两两交换链表中的节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-18 16:56
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        new Solution().swapPairs(node);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = temp.next.next;
        }
        return dummy.next;
    }
}
