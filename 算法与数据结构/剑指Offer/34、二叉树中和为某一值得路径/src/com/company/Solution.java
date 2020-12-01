package com.company;

import java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 34、二叉树中和为某一值得路径
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-01 19:51
 **/
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recurse(root, sum, path, result);
        return result;
    }

    private void recurse(TreeNode root, int sum,
                         List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList(path));
        }
        recurse(root.left, sum, path, result);
        recurse(root.right, sum, path, result);
        path.remove(path.size() - 1);
    }

}
