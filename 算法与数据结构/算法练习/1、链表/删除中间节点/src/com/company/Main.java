package com.company;

public class Main {

    public static void main(String[] args) {
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(9);
        one.next = two;
        two.next = three;
        three.next = four;
        new Solution().deleteNode(two);
        System.out.println(one);
    }
}
