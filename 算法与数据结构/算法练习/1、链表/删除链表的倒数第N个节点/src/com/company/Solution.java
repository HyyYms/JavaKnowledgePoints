package com.company;

import java.util.ArrayList;

import java.util.List;

/**
 * @program: 删除链表的倒数第N个节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-16 10:47
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode node1 = new Solution().removeNthFromEnd2(node, 1);
        System.out.println(node1);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (n == list.size()) {
            return head.next;
        }
        node = list.get(0);
        ListNode result = node;
        for (int i = 1; i < list.size(); i++) {
            if (i == list.size() - n && i + 1 < list.size()) {
                continue;
            } else if (i == list.size() - n && i + 1 >= list.size()) {
                node.next = null;
            } else {
                node.next = list.get(i);
                node = node.next;
            }
        }
        return result;
    }
}
