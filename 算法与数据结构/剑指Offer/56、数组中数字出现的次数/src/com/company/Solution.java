package com.company;

import java.util.Arrays;

/**
 * @program: 56、数组中数字出现的次数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-07 10:53
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().singleNumbers(new int[]{
                4, 1, 4, 6
        });
    }

    // 位运算
    public int[] singleNumbers2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }
        return new int[]{first,second};
    }

    // 遍历一遍——n
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums);
        int[] res = new int[2];
        int k = 0;
        int fast = 1;
        int slow = 0;
        while (slow < nums.length) {
            if (slow == nums.length - 1 || nums[slow] != nums[fast]) {
                res[k] = nums[slow];
                k++;
                slow = fast;
                fast = slow + 1;
                if (k == 2) {
                    break;
                }
            } else {
                slow += 2;
                fast += 2;
            }
        }
        return res;
    }
}
