package com.company;

/**
 * @program: 数组
 * @description: 矩阵相乘
 * @author: Mr.Huang
 * @create: 2020-10-22 21:07
 **/
public class ArrayMul {

    public double[][] get(double[][] array1, double[][] array2) {
        int n = array1.length;
        int m = array1[0].length;
        double[][] array3 = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    array3[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return array3;
    }
}
