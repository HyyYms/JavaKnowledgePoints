package com.company;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @program: 35、复杂链表的复制
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-01 20:35
 **/
public class Solution {

    public static void main(String[] args) {
        Node one = new Node(7);
        Node two = new Node(13);
        Node three = new Node(11);
        Node four = new Node(10);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        one.random = null;
        two.random = one;
        three.random = five;
        four.random = three;
        five.random = one;
        new Solution().copyRandomList(one);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node moveNode = head.next;
        Node result = head.next;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (moveNode != null && moveNode.next != null) {
                moveNode.next = moveNode.next.next;
                moveNode = moveNode.next;
            }
        }
        return result;
    }
}
