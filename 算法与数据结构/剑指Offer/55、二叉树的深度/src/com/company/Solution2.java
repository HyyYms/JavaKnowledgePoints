package com.company;

/**
 * @program: 55、平衡二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-06 17:35
 **/
public class Solution2 {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root, 1);
        return isBalanced;
    }

    private int helper(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right);
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(helper2(root.left) - helper2(root.right)) <= 1
                && isBalanced2(root.left) && isBalanced2(root.right);
    }

    public int helper2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(helper2(root.left), helper2(root.right)) + 1;
    }
}
