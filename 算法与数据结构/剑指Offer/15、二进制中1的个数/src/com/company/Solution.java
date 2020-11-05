package com.company;

/**
 * @program: 二进制中1的个数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-29 11:26
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(9 & 15);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
