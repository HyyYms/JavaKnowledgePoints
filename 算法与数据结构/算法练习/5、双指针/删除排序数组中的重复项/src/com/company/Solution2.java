package com.company;

import java.util.Arrays;

/**
 * @program: 移除元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-14 23:47
 **/
public class Solution2 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
