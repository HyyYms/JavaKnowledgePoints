package com.company.second.test;

import com.company.ListNode;
import com.company.second.Solution;

/**
 * @program: 反转链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 18:41
 **/
public class Test {
    public static void main(String[] args) {
        // 空链表测试
        ListNode empty = null;
        empty = Solution.reverseBetween(empty,0,0);
        show(empty);

        // 一个节点链表测试
        ListNode one = new ListNode(1);
        one = Solution.reverseBetween(one,0,1);
        show(one);

        // 两个节点链表测试
        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two = Solution.reverseBetween(two,0,0);
        show(two);

        // 正常链表测试
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list = Solution.reverseBetween(list,2,4);
        show(list);
    }

    private static void show(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
