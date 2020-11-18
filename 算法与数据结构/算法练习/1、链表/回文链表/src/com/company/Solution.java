package com.company;


import java.util.LinkedList;
import java.util.List;

/**
 * @program: 回文链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-17 23:02
 **/
public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode two = new ListNode(2);
        node.next = two;
        new Solution().isPalindrome(node);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstEndNode = endOfFirstHalf(head);
        ListNode secondStartNode = reverseList(firstEndNode.next);

        boolean result = true;
        ListNode first = head;
        ListNode second = secondStartNode;
        while (result && second != null) {
            if (first.val != second.val) {
                result = false;
            }
            first = first.next;
            second = second.next;
        }
        firstEndNode.next = reverseList(secondStartNode);
        return result;
    }

    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            node = node.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode node) {
        ListNode p1 = node;
        ListNode p2 = node;
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }
}
