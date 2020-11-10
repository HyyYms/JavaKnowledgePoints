package com.company;

/**
 * @program: 爬楼梯
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-10 22:49
 **/
public class Solution {

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int num1 = 0;
        int num2 = 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            num1 = num2;
            num2 = result;
            result = num1 + num2;
        }
        return result;
    }
}
