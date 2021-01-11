package com.company;

/**
 * @program: 第一个错误的版本
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 22:00
 **/
public class Solution {

    public int firstBadVersion(int n) {
        int mid;
        int start = 0;
        int end = n;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
