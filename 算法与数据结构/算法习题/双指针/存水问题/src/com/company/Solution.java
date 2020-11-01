package com.company;

/**
 * @program: 存水问题
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-01 11:08
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int startHeight = height[start];
        int endHeight = height[end];
        int total = 0;
        while (start < end) {
            if (startHeight < endHeight) {
                if (startHeight > height[start + 1]) {
                    total += startHeight - height[start + 1];
                } else {
                    startHeight = height[start + 1];
                }
                start++;
            } else {
                if (endHeight > height[end - 1]) {
                    total += endHeight - height[end - 1];
                } else {
                    endHeight = height[end - 1];
                }
                end--;
            }
        }
        return total;
    }
}
