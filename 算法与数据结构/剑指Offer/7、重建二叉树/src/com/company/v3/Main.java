package com.company.v3;



import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Main {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        stack.push(root);

        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (inorder[j] != cur.val) {
                root.left = new TreeNode(preorder[i]);
                cur = root.left;
                stack.push(cur);
            } else {
                while (stack.peek().val == inorder[j] && !stack.empty()) {
                    cur = stack.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
            return root;
        }
        return null;
    }
}
