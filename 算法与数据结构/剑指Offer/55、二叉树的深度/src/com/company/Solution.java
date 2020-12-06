package com.company;


import java.util.LinkedList;

/**
 * @program: 55、二叉树的深度
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-06 16:57
 **/
public class Solution {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        new Solution().maxDepth2(node);
    }

    // 深度遍历——递归
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, 1);
        int right = helper(root.right, 1);
        return Math.max(left, right);
    }

    private int helper(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);
        return Math.max(left, right);
    }

    // 层次遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return level;
    }
}
