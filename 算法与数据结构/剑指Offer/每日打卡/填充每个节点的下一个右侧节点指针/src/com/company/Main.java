package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public Node connect(Node root) {
        // 边界条件的判断——一开始没有判断出
        if (root == null) {
            return root;
        }
        root.next = null;
        return help(root);
    }

    private Node help(Node root) {
        // 边界条件的判断——一开始没有判断出
        if (root.left == null && root.right == null) {
            return root;
        }
        assert root.left != null;
        root.left.next = root.right;
        if (root.next == null) {
            root.right.next = null;
        } else {
            root.right.next = root.next.left;
        }
        help(root.left);
        help(root.right);
        return root;
    }
}
