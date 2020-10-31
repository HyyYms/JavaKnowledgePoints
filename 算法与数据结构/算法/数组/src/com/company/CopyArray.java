package com.company;

/**
 * @program: 数组
 * @description: 复制数组
 * @author: Mr.Huang
 * @create: 2020-10-22 21:01
 **/
public class CopyArray {

    public double[] get(double[] array) {
        int n = array.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
