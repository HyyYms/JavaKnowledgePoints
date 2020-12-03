package com.company;

/**
 * @program: 42、连续子数组的最大和
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-03 09:25
 **/
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = pre < 0 ? nums[i] : pre + nums[i];
            pre = cur;
            max = Math.max(max, cur);
        }
        return max;
    }
}
