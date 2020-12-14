package com.company;

/**
 * @program: 删除排序数组中的重复项
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-14 11:17
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{
                1, 1, 2
        });
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
