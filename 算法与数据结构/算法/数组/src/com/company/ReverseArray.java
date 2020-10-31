package com.company;

/**
 * @program: 数组
 * @description: 颠倒数组元素的顺序
 * @author: Mr.Huang
 * @create: 2020-10-22 21:03
 **/
public class ReverseArray {

    public double[] get(double[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            double temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        return array;
    }
}
