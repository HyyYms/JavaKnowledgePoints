package com.company;

/**
 * @program: x的平方根
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 15:30
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().mySqrt(2147395599);
    }

    public int mySqrt(int x) {
        // long ： 处理大数情况
        long mid;
        long start = 0;
        long end = x / 2 + 1;
        while (start <= end) {
            mid = start + (end - start + 1) / 2;
            long temp = mid * mid;
            long temp2 = (mid + 1) * (mid + 1);
            if (temp == x || (temp < x && temp2 > x)) {
                return (int) mid;
            } else if (temp > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
