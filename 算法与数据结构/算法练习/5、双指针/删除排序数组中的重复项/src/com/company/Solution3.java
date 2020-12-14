package com.company;

import java.util.Arrays;

/**
 * @program: 移动零
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-14 23:48
 **/
public class Solution3 {

    // 双指针
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = 0;
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }

    // 暴力解法
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
