package com.company;

/**
 * @program: 65、不用加减乘除做加法
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-04 14:55
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().add(5, 7);
    }

    public int add(int a, int b) {
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }
}
