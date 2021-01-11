package com.company;

/**
 * @program: 有效的完全平方数
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 21:55
 **/
public class Solution {

    public boolean isPerfectSquare(int num) {
        long mid;
        long start = 1;
        long end = num / 2 + 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
