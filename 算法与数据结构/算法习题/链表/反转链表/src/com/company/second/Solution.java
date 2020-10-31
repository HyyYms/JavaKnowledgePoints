package com.company.second;

import com.company.ListNode;

/**
 * @program: 反转链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 18:23
 **/
public class Solution {

//    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//    说明:
//            1 ≤ m ≤ n ≤ 链表长度。
//
//    示例:
//
//    输入: 1->2->3->4->5->NULL, m = 2, n = 4
//    输出: 1->4->3->2->5->NULL

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        for (int i = m; i < n; i++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        preM.next = nNode;
        mNode.next = postN;
        return dummy.next;
    }
}
