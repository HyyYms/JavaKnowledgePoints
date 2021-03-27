package com.company;

import java.util.ArrayList;

import java.util.List;

/**
 * @program: BiNode
 * @description:
 * @author: Mr.Huang
 * @create: 2021-02-02 14:37
 **/
public class Solution2 {


    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = dfs(root, new ArrayList<Integer>());
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int num = list.get(left) + list.get(right);
            if (num == k) {
                return true;
            } else if (num > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return list;
    }
}
