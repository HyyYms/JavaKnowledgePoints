package com.company;

import java.util.LinkedList;

import java.util.List;

/**
 * @program: 分隔链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 10:19
 **/
public class Solution2 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return null;
        }

        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = root;

        if (k >= length) {
            ListNode[] result = new ListNode[k];
            for (int i = 0; i < length; i++) {
                result[i] = new ListNode(cur.val);
                cur = cur.next;
            }
            return result;
        }

        int num = length / k;
        int remainder = length % k;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode pre = new ListNode(0);
            ListNode node = pre;
            for (int j = 0; j < num; j++) {
                node.next = new ListNode(cur.val);
                node = node.next;
                cur = cur.next;
            }
            if (remainder != 0) {
                node.next = new ListNode(cur.val);
                node = node.next;
                cur = cur.next;
                remainder--;
            }
            result[i] = pre.next;
        }
        return result;
    }
}
