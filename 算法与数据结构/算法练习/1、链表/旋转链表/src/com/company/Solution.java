package com.company;

/**
 * @program: 旋转链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-18 17:53
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new Solution().rotateRight(node, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // 首尾相连
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = cur;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
            len += 1;
        }
        pre.next = head;

        k = k % len;
        ListNode result = head.next;
        pre = head;
        for (int i = 1; i < len - k; i++) {
            pre = pre.next;
            result = result.next;
        }
        pre.next = null;
        return result;
    }
}
