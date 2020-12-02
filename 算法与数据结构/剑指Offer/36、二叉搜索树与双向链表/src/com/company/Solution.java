package com.company;


import java.util.LinkedList;

/**
 * @program: 36、二叉搜索树与双向链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-01 21:01
 **/
public class Solution {


    Node dfsPre, dfsHead;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        dfsHead.left = dfsPre;
        dfsPre.right = dfsHead;
        return dfsHead;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (dfsPre != null) {
            dfsPre.right = cur;
        } else {
            dfsHead = cur;
        }
        cur.left = dfsPre;
        dfsPre = cur;
        dfs(cur.right);
    }

    public Node treeToDoublyList1(Node root) {
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
