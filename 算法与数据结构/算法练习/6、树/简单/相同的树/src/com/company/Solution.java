package com.company;


/**
 * @program: 相同的树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 16:52
 **/
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
