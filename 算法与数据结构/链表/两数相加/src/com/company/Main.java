package com.company;


import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

public class Main {

//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//    示例：
//
//            ```
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//```


    public static void main(String[] args) {
        // write your code here
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int number = l1.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int number = l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number);
            pre = pre.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head.next;
    }

    // 改进后
    public static ListNode myAddTwoNumbers(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int i = 0;
        while (list1 != null || list2 != null) {
            int num = 0;
            if (list1 == null) {
                num = list2.val + i;
                pre.next = new ListNode(num % 10);
                i = num / 10;
                pre = pre.next;
                list2 = list2.next;
                continue;
            } else if (list2 == null) {
                num = list1.val + i;
                pre.next = new ListNode(num % 10);
                i = num / 10;
                pre = pre.next;
                list1 = list1.next;
                continue;
            } else {
                num = list1.val + list2.val + i;
                pre.next = new ListNode(num % 10);
                i = num / 10;
                pre = pre.next;
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        if (i != 0) {
            pre.next = new ListNode(i % 10);
        }
        return head.next;
    }
}
