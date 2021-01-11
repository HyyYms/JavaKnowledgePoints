package com.company;

/**
 * @program: 统计有序矩阵中的负数
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 21:03
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().countNegatives(new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}});
    }

    public int countNegatives(int[][] grid) {
        int sum = 0;
        int right = grid[0].length - 1;
        for (int[] ints : grid) {
            while (right >= 0) {
                if (ints[right] < 0) {
                    right--;
                } else {
                    break;
                }
            }
            sum += grid[0].length - 1 - right;
        }
        return sum;
    }
}
