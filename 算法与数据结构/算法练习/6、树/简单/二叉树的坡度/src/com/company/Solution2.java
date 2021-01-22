package com.company;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-20 15:42
 **/
public class Solution2 {

    public Node union(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        Node pre = new Node();
        Node cur = new Node();
        pre.next = cur;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return pre.next;
    }
}
