package com.company;

import java.util.LinkedList;

/**
 * @program: 奇偶链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 11:36
 **/
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        int num = 1;

        while (head != null) {
            if (num % 2 != 0) {
                odd.next = head;
                head = head.next;
                odd = odd.next;
                odd.next = null;
            } else {
                even.next = head;
                head = head.next;
                even = even.next;
                even.next = null;
            }
            num++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

}
