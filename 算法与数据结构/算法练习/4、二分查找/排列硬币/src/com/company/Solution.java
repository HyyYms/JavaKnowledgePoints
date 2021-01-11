package com.company;

/**
 * @program: 排列硬币
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 16:33
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().arrangeCoins(5);
    }

    public int arrangeCoins(int n) {
        long mid;
        long start = 1;
        long end = n;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long sum = (mid + 1) * mid / 2;
            if (sum == n) {
                return (int) mid;
            } else if (sum > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) end;
    }
}
