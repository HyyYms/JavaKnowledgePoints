package com.company;


import java.util.LinkedList;

/**
 * @program: 27、二叉树的镜像
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 20:37
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        new Solution().mirrorTree2(node);
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree2(root.right);
        root.right = mirrorTree2(temp);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            TreeNode temp = pop.right;
            pop.right = pop.left;
            pop.left = temp;
        }

        return root;
    }
}
