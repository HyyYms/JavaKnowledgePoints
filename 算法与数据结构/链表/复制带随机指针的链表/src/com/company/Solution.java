package com.company;

import java.util.HashMap;

/**
 * @program: 复制带随机指针的链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 22:26
 **/
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
        Node newNode = head;
        while (newNode != null) {
            if (!hashMap.containsKey(newNode)) {
                Node node = new Node(newNode.val);
                hashMap.put(newNode, node);
            }
            if (newNode.random != null) {
                Node random = newNode.random;
                if (!hashMap.containsKey(random)) {
                    Node node = new Node(random.val);
                    hashMap.put(random, node);
                }
                hashMap.get(newNode).random = hashMap.get(random);
            }
            newNode = newNode.next;
        }
        newNode = head;
        while (newNode.next != null) {
            hashMap.get(newNode).next = hashMap.get(newNode.next);
            newNode = newNode.next;
        }
        return hashMap.get(head);
    }
}
