package com.company;

public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        new Main().isPalindrome(node);
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode firstEndNode = endOfFirstHalf(head);
        ListNode secondStartNode = reverseList(firstEndNode.next);

        boolean result = true;
        ListNode p1 = head;
        ListNode p2  = secondStartNode;

        while(result && p2 != null) {
            if (p2.val != p1.val) {
                result = false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }

        firstEndNode.next = reverseList(secondStartNode);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }
}
