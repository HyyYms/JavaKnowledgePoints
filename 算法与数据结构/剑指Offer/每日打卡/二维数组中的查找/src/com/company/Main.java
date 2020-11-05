package com.company;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
//         
//
//        示例:
//
//        现有矩阵 matrix 如下：
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        给定 target = 5，返回 true。
//
//        给定 target = 20，返回 false。
//

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        findNumberIn2DArray(matrix, 16);
    }

    // 通过选取右上到左下的方式，将其转变为树形结构类似于二叉搜索树。节点的左边都为比节点小的，节点的右边都为比节点大的

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean myFindNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int column = matrix.length;
        int row = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[column - 1][row - 1]) {
            return false;
        }
        int i = 0, j = 0;
        int x = 0, y = 0;
        do {
            if (target == matrix[i][j]) {
                return true;
            }
            x = i + 1;
            y = j + 1;
            if (matrix.length < x || matrix[0].length < y) {
                return false;
            }
            for (int u = 0; u <= x; u++) {
                if (target == matrix[x][u]) {
                    return true;
                }
            }
            for (int o = 0; o < y; o++) {
                if (target == matrix[o][y]) {
                    return true;
                }
            }
            i++;
            j++;
        } while (target >= matrix[i][j]);
        return false;
    }
}
