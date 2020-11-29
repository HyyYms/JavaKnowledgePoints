package com.company;



import java.util.*;

/**
 * @program: 32、从上到下打印二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-29 17:36
 **/
public class Solution3 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(1);
        node.left.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(1);
        node.right.right = new TreeNode(-1);
        node.right.right.right = new TreeNode(8);
        node.right.left = new TreeNode(3);
        node.right.left.right = new TreeNode(6);
        new Solution3().levelOrder3(node);
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) {
                    // 奇数层 -> 队列尾部
                    tmp.addLast(node.val);
                } else {
                    // 偶数层 -> 队列头部
                    tmp.addFirst(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = level % 2 != 0 ? queue.pollFirst() : queue.pollLast();
                list.add(poll.val);
                if (level % 2 != 0) {
                    if (poll.left != null) {
                        queue.offerLast(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offerLast(poll.right);
                    }
                } else {
                    if (poll.right != null) {
                        queue.offerFirst(poll.right);
                    }
                    if (poll.left != null) {
                        queue.offerFirst(poll.left);
                    }
                }
            }
            level++;
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            LinkedList<TreeNode> help = new LinkedList<>();
            while (!queue.isEmpty()) {
                help.offer(queue.pollLast());
            }
            for (int i = 0; i < length; i++) {
                TreeNode poll = help.poll();
                list.add(poll.val);
                if (level % 2 != 0) {
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                } else {
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                }
            }
            level++;
            result.add(list);
        }
        return result;
    }
}
