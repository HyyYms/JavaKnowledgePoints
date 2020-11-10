package com.company;

/**
 * @program: 爬楼梯
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-10 22:49
 **/
public class Solution {

    public int climbStairs(int n) {
        /*
           时间过长
            if (n <= 3) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        */
        /*
            我的解法
            int num1 = 0;
            int num2 = 0;
            int result = 1;
            for (int i = 1; i <= n; i++) {
                num1 = num2;
                num2 = result;
                result = num1 + num2;
            }
            return result;
        */
        if (n < 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i % 3] = steps[(i - 1) % 3] + steps[(i - 2) % 3];
        }
        return steps[(n - 1) % 3];
    }
}
