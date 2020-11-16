package com.company;

/**
 * @program: 删除中间节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-16 22:59
 **/
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = new ListNode(0);
        pre.next = node;
        while (node != null) {
            if (node.next != null) {
                node.val = node.next.val;
                node = node.next;
                pre = pre.next;
            } else {
                pre.next = null;
                node = null;
            }
        }
    }
}
