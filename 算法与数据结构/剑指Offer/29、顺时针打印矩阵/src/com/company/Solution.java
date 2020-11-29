package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: 29、顺时针打印矩阵
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-29 15:42
 **/
public class Solution {

    public static void main(String[] args) {
        int[][] arr = {{7, 9, 6}};
        System.out.println(
                Arrays.toString(new Solution().spiralOrder(arr))
        );
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;
        int[] res = new int[(rowEnd + 1) * (columnEnd + 1)];
        int k = 0;
        while (rowStart < rowEnd && columnStart < columnEnd) {
            // 从左往右
            for (int i = columnStart; i < columnEnd; i++, k++) {
                res[k] = matrix[rowStart][i];
            }
            // 从上往下
            for (int i = rowStart; i < rowEnd; i++, k++) {
                res[k] = matrix[i][columnEnd];
            }
            // 从右往左
            for (int i = columnEnd; i > columnStart; i--, k++) {
                res[k] = matrix[rowEnd][i];
            }
            // 从下往上
            for (int i = rowEnd; i > rowStart; i--, k++) {
                res[k] = matrix[i][columnStart];
            }
            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;
        }
        if (rowStart == rowEnd) {
            while (columnStart <= columnEnd) {
                res[k] = matrix[rowStart][columnStart];
                k++;
                columnStart++;
            }
        } else if (columnStart == columnEnd) {
            while (rowStart <= rowEnd) {
                res[k] = matrix[rowStart][columnStart];
                k++;
                rowStart++;
            }
        }
        return res;
    }
}
