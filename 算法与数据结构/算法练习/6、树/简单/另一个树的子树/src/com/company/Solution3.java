package com.company;

/**
 * @program: 另一个树的子树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 17:10
 **/
public class Solution3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(1);
//        root2.right = new TreeNode(2);

        new Solution3().isSubtree(root, root2);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        return search(s, t);
    }

    public boolean search(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return judge(s, t) || search(s.left, t) || search(s.right, t);
    }

    private boolean judge(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val &&
                judge(s.left, t.left) &&
                judge(s.right, t.right);
    }
}
