package com.company;

/**
 * @program: 最大连续1的个数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-17 23:48
 **/
public class Solution2 {

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int num = 0;
        int historyOnesMax = 0;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 1) {
                num++;
            }
            historyOnesMax = Math.max(num, historyOnesMax);
            if (right - left + 1 > historyOnesMax + K) {
                if (A[left] == 1) {
                    num--;
                }
                left++;
            }
        }
        return A.length - left;
    }
}
