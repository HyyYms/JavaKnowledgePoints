package com.company;


import java.util.ArrayList;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: 32、从上到下打印二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-29 16:45
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        new Solution().levelOrder2(node);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> help = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                help.offer(poll);
            }
            if (0 == queue.size()) {
                List<Integer> list = new ArrayList<>();
                while (!help.isEmpty()) {
                    TreeNode helpPoll = help.poll();
                    if (helpPoll.left != null) {
                        queue.offer(helpPoll.left);
                    }
                    if (helpPoll.right != null) {
                        queue.offer(helpPoll.right);
                    }
                    list.add(helpPoll.val);
                }
                result.add(list);
            }
        }
        return result;
    }
}
