package com.company;

/**
 * @program: 将有序数组转换为二叉搜索树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 16:51
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrToTree(nums, 0, nums.length - 1);
    }

    private TreeNode arrToTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrToTree(nums, left, mid - 1);
        root.right = arrToTree(nums, mid + 1, right);
        return root;
    }


}
