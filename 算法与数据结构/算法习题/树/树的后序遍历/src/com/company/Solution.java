package com.company;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 树的后序遍历
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-01 20:34
 **/
public class Solution {


    // 不破坏原有的数据结构
    public List<Integer> postorderTraversalByStack2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        TreeNode pre = null;

        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (pre == null || pre.left == current || pre.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == pre) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                result.add(current.val);
                stack.pop();
            }
            pre = current;
        }
        return result;
    }

    // 破坏原有的数据结构
    public List<Integer> postorderTraversalByStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            if (treeNode.right == null && treeNode.left == null) {
                result.add(stack.pop().val);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                treeNode.right = null;
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
                treeNode.left = null;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}
