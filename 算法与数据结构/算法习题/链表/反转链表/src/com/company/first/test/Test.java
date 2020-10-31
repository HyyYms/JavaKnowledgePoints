package com.company.first.test;


import com.company.ListNode;
import com.company.first.Solution;

/**
 * @program: 反转链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 17:40
 **/
public class Test {

    public static void main(String[] args) {
        // 空链表测试
        ListNode empty = null;
        empty = Solution.reverseList(empty);
        System.out.println("空链表测试");
        show(empty);

        // 一个节点链表测试
        ListNode one = new ListNode(1);
        one = Solution.reverseList(one);
        System.out.println("一个节点链表测试");
        show(one);

        // 两个节点链表测试
        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two = Solution.reverseList(two);
        System.out.println("两个节点链表测试");
        show(two);

        // 正常链表测试
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list = Solution.reverseList(list);
        System.out.println("正常链表测试");
        show(list);
    }

    private static void show(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
