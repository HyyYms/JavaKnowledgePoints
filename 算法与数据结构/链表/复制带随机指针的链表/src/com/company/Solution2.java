package com.company;


/**
 * @program: 复制带随机指针的链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 23:01
 **/
public class Solution2 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }


    private Node split(Node head) {
        Node result = head.next;
        Node move = head.next;
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
            if (move != null && move.next != null){
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }

    private void copyRandom(Node head) {
        Node node = head;
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }


    private void copy(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }
}
