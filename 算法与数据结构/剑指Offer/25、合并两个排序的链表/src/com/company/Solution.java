package com.company;

/**
 * @program: 25、合并两个排序的链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 15:29
 **/
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode pre = new ListNode(0);
        ListNode result = pre;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;
        return result.next;
    }

}
