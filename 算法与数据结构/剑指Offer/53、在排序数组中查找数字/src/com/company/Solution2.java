package com.company;

/**
 * @program: 53、在排序数组中查找数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-06 10:36
 **/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().missingNumber(new int[]{
                0, 2
        });
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
