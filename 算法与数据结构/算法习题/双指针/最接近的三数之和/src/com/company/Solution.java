package com.company;

import java.util.Arrays;

/**
 * @program: 最接近的三数之和
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-04 23:54
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{
                1,2,1,-4
        }, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == target) {
                    return target;
                } else if (nums[start] + nums[end] + nums[i] > target) {
                    int temp = nums[start] + nums[end] + nums[i];
                    if (temp - target < min) {
                        min = temp - target;
                        res = temp;
                    }
                    end--;
                } else {
                    int temp = nums[start] + nums[end] + nums[i];
                    if (target - temp < min) {
                        min = target - temp;
                        res = temp;
                    }
                    start++;
                }
            }
        }
        return res;
    }
}
