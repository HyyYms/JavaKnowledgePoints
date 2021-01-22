package com.company;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: 二叉树的堂兄弟节点
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 18:06
 **/
public class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return true;
        }
        HashMap<TreeNode, TreeNode> father = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        father.put(root, root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isX = false;
            boolean isY = false;
            TreeNode xFather = new TreeNode();
            TreeNode yFather = new TreeNode();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    father.put(poll.left, poll);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    father.put(poll.right, poll);
                }
                if (poll.val == x) {
                    isX = true;
                    xFather = father.get(poll);
                }
                if (poll.val == y) {
                    isY = true;
                    yFather = father.get(poll);
                }
            }
            if (isX && isY && (xFather.val != yFather.val)) {
                return true;
            }
        }
        return false;
    }
}
