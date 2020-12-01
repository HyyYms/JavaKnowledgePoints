package com.company;


import java.util.LinkedList;

/**
 * @program: 36、二叉搜索树与双向链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-01 21:01
 **/
public class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;
        Node head = root;
        Node pre = new Node();
        boolean isHead = false;
        LinkedList<Node> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
                if (cur != null && !isHead) {
                    head = cur;
                }
                if (cur == null) {
                    isHead = true;
                }
            }
            Node pop = stack.pop();
            pop.left = pre;
            pre.right = pop;
            pre = pop;
            cur = pop.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}
