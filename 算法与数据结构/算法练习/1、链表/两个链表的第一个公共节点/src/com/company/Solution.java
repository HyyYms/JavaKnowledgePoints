package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: 两个链表的第一个公共节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-16 19:19
 **/
public class Solution {

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (headA != null) {
            map.put(headA.val, headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB.val) && headB == map.get(headB.val)) {
                return map.get(headB.val);
            }
            headB = headB.next;
        }
        return null;
    }
}
