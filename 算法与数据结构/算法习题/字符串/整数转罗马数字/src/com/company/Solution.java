package com.company;

/**
 * @program: 整数转罗马数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 13:54
 **/
public class Solution {

    public static void main(String[] args) {
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
}
