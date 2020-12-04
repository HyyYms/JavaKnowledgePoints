package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 67、把字符串转换成整数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-03 23:35
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().strToInt("2147483646");
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int i = 1;
        int sign = 1;
        int bndry = Integer.MAX_VALUE / 10;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        int num = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if (num > bndry || (num == bndry && chars[j] > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + (chars[j] - '0');
        }
        return num * sign;
    }
}
