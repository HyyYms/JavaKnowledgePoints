package com.company;

import java.util.Arrays;

/**
 * @program: 反转字符串中的元音字母
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-15 10:49
 **/
public class Solution {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            while (left <= right && !isValid(chars[left])) {
                left++;
            }
            while (left <= right && !isValid(chars[right])) {
                right--;
            }
            if (left <= right) {
                Character temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isValid(Character ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
