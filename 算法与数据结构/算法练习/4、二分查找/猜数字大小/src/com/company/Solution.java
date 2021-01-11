package com.company;

/**
 * @program: 猜数字大小
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 21:48
 **/
public class Solution {

    public int guessNumber(int n) {
        int mid;
        int start = 1;
        int end = n;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
