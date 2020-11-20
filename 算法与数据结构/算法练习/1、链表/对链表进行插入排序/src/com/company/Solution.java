package com.company;

/**
 * @program: 对链表进行插入排序
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 10:01
 **/
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (node.val < cur.val) {
                node
            }
        }
    }
}
