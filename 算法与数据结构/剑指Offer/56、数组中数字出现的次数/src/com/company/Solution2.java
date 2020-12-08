package com.company;

/**
 * @program: 56、数组中数字出现的次数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-07 11:40
 **/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().singleNumber(new int[]{
                3, 4, 3, 3
        });
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cur = 0;
            for (int num : nums) {
                if ((num & (1 << i)) > 0) {
                    cur++;
                }
            }
            if (cur % 3 == 1) {
                res ^= 1 << i;
            }
        }
        return res;
    }
}
