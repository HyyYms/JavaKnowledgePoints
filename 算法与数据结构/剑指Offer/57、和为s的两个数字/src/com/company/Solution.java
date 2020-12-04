package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: 57、和为s的两个数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-04 23:18
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                break;
            }
        }
        res[0] = nums[left];
        res[1] = nums[right];
        return res;
    }
}
