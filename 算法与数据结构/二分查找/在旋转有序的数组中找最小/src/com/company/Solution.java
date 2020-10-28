package com.company;

/**
 * @program: 在旋转有序的数组中找最小
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-28 13:51
 **/
public class Solution {
    public static void main(String[] args) {
        Solution.findMin(
                new int[]{5, 1, 2, 3, 4}
        );
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] <= nums[end] ? nums[start] : nums[end];
    }
}
