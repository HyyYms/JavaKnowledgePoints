package com.company;

/**
 * @program: 47、礼物的最大价值
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-10 10:36
 **/
public class Solution {

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int[] x = new int[]{0, 1};
        int[] y = new int[]{1, 0};

    }
}
