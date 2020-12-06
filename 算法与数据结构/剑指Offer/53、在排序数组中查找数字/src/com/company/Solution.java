package com.company;

/**
 * @program: 53、在排序数组中查找数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-05 18:44
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().search1(new int[]{
                1
        }, 1);
    }

    // 找到元素的边界
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 找到元素后，从中间开始往两边找边界
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = end = mid;
                while (start > 0 && nums[start] == nums[start - 1]) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end++;
                }
                break;
            } else if (nums[mid] > target) {
                end--;
            } else {
                start++;
            }
        }
        return end < start ? 0 : end - start + 1;
    }

}
