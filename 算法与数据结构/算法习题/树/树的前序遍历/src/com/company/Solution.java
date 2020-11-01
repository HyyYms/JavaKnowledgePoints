package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 树的前序遍历
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-01 19:31
 **/
public class Solution {

    public List<Integer> preorderTraversalByStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }
}
