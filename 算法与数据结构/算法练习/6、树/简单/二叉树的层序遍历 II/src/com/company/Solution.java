package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 二叉树的层序遍历 II
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 15:57
 **/
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> stack = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            stack.push(list);
        }
        return stack;
    }
}
