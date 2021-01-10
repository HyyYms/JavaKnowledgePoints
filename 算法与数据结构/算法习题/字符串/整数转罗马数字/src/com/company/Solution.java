package com.company;

import java.util.HashMap;

/**
 * @program: 整数转罗马数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 13:54
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().romanToInt("IV");
        new Solution().intToRoman(3);
    }

    public String intToRoman(int num) {
        String[] one = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundred = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousand = new String[]{"", "M", "MM", "MMM"};
        StringBuilder sb = new StringBuilder();
        sb.append(thousand[num / 1000]).append(hundred[num % 1000 / 100]).append(ten[num % 100 / 10]).append(one[num % 10]);
        return sb.toString();
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int num = getIntValue(s.charAt(i));
            if (num > preNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getIntValue(Character ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
