package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: 百度笔试
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-21 21:12
 **/
public class Solution {

    private ListNode pre = new ListNode(-1);
    private ListNode cur = pre;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<ListNode> res = new Solution().binaryTreePaths(root);
        for (ListNode list : res) {
            while (list != null) {
                System.out.println(list.val);
            }
        }
    }

    public List<ListNode> binaryTreePaths(TreeNode root) {
        ListNode path = new ListNode(-1);
        List<ListNode> res = new ArrayList<>();
        help(root, res);
        return res;
//        constructPaths(root, "", paths);

//        return paths;
    }

    public void help(TreeNode root, List<ListNode> res) {
        if (root == null) {
            res.add(pre.next);
            return;
        }

        while (root != null) {
            cur.next = new ListNode(root.val);
            cur = cur.next;
            help(root.left, path, res);
            help(root.right, path, res);
            path.next = null;
        }
    }
//    public void constructPaths(TreeNode root, String path, List<String> paths) {
//        if (root != null) {
//            new ListNode(Integer.valueOf(path));
//
//            StringBuffer pathSB = new StringBuffer(path);
//            pathSB.append(Integer.toString(root.val));
//            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
//                paths.add(pathSB.toString());  // 把路径加入到答案中
//            } else {
//                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
//                constructPaths(root.left, pathSB.toString(), paths);
//                constructPaths(root.right, pathSB.toString(), paths);
//            }
//        }
//    }
}
