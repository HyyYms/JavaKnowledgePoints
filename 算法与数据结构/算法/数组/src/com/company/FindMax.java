package com.company;

/**
 * @program: 数组
 * @description: 寻找数组中最大的元素
 * @author: Mr.Huang
 * @create: 2020-10-22 20:56
 **/
public class FindMax {
    public double get(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
