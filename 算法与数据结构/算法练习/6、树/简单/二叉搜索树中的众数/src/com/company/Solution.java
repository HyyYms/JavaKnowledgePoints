package com.company;

import java.util.*;

/**
 * @program: 二叉搜索树中的众数
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 15:44
 **/
public class Solution {

    int dfsBase = 0;
    int dfsCount = 0;
    int dfsMaxCount = 0;
    List<Integer> list = new ArrayList<>();

    // 递归
    public int[] findMode2(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        search(root.val);
        dfs(root.right);
    }

    private void search(int val) {
        if (val == dfsBase) {
            dfsCount++;
        } else {
            dfsBase = val;
            dfsCount = 1;
        }
        if (dfsCount == dfsMaxCount) {
            list.add(dfsBase);
        }
        if (dfsCount > dfsMaxCount) {
            dfsMaxCount = dfsCount;
            list.clear();
            list.add(dfsBase);
        }
    }


    // 迭代
    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        int base = 0;
        int count = 0;
        int maxCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (base == current.val) {
                count++;
            } else {
                base = current.val;
                count = 1;
            }
            if (count == maxCount) {
                list.add(base);
            }
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(base);
            }
            current = current.right;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
