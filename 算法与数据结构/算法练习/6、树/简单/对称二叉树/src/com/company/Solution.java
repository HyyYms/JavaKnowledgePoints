package com.company;

import java.util.LinkedList;

/**
 * @program: 对称二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 15:05
 **/
public class Solution {


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkQueue(root.left, root.right);
    }

    private boolean checkQueue(TreeNode left, TreeNode right) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (queue.size() != 0) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                check(left.left, right.right) &&
                check(left.right, right.left);
    }
}
