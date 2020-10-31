package com.company;

/**
 * @program: 数组
 * @description: 计算数组元素的平均值
 * @author: Mr.Huang
 * @create: 2020-10-22 21:00
 **/
public class CalculateAver {

    public double get(double[] array) {
        int N = array.length;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }
        return sum / N;
    }
}
