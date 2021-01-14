package com.company;

/**
 * @program: 魔术索引
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 13:58
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().findMagicIndex1(new int[]{0, 0, 2});
    }

    // 分治
    public int findMagicIndex2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int leftNum = search(nums, left, mid - 1);
        if (leftNum != -1) {
            return leftNum;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return search(nums, mid + 1, right);
    }

    // 跳跃法
    public int findMagicIndex1(int[] nums) {
        int min = 0;
        while (min < nums.length) {
            if (min == nums[min]) {
                return min;
            } else if (min < nums[min]) {
                min = nums[min];
            } else {
                min++;
            }
        }
        return -1;
    }
}
