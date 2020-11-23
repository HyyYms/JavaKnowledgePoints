package com.company;

import java.util.LinkedList;

/**
 * @program: 表现良好的最长时间段
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 19:00
 **/
public class Solution {

    public int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) {
            return 0;
        }
        int[] arr = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            arr[i] = hours[i] > 8 ? 1 : -1;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            for (int j = i; j < arr.length; j++) {
                num += arr[j];
                if (num > 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
            if (arr.length - i <= max) {
                return max;
            }
        }
        return max;
    }
}
