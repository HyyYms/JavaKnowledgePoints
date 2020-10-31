package com.company;

/**
 * @program: 寻找峰值
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-28 14:13
 **/
public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
