package com.company;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 32、从上到下打印二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-29 17:27
 **/
public class Solution2 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            list.add(poll.val);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
