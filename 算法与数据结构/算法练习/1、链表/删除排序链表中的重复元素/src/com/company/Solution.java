package com.company;

import java.util.HashMap;

/**
 * @program: 删除排序链表中的重复元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-18 11:34
 **/
public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        new Solution().deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
