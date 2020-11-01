package com.company;

import java.util.Arrays;

/**
 * @program: 验证三角形
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-31 12:41
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().triangleNumber(new int[]{
                1, 2, 3, 4, 5, 6
        }));
    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    total += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }

    public int myTriangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = j + 1;
                while (k < nums.length && (nums[i] + nums[j] > nums[k])) {
                    count++;
                    k++;
                }
            }
        }
        return count;
    }

}
