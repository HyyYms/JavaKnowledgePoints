package com.company;

import java.util.List;

/**
 * @program: 两数相加
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-26 19:39
 **/
public class Test {
    public static void main(String[] args) {

        // 空链表测试
        ListNode empty1 = new ListNode();
        ListNode empty2 = new ListNode();
        ListNode empty = Solution.addTwoNumbers(empty1, empty2);
        show(empty);

        // 一个空链表测试
        ListNode oneEmpty = new ListNode();
        ListNode l = new ListNode(2);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        ListNode one = Solution.addTwoNumbers(oneEmpty, l);
        show(one);
        
        // 正常链表测试1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = Solution.addTwoNumbers(l1, l2);
        show(node);

        // 正常链表测试2
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(9);

        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);
        l4.next.next = new ListNode(9);
        l4.next.next.next = new ListNode(9);
        l4.next.next.next.next = new ListNode(9);
        l4.next.next.next.next.next = new ListNode(9);

        ListNode node2 = Solution.addTwoNumbers(l1, l2);
        show(node2);
    }

    private static void show(ListNode node) {
        System.out.println("输出结果：");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
