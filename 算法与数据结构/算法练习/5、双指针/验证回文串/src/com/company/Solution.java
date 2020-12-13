package com.company;

import java.util.regex.Pattern;

/**
 * @program: 验证回文串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-13 23:31
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 <= p2) {
            while (p1 < s.length() && !judgeChar(s.charAt(p1))) {
                p1++;
            }
            while (p2 > 0 && !judgeChar(s.charAt(p2))) {
                p2--;
            }
            if (p1 >= s.length() || p2 < 0) {
                break;
            } else if (Math.abs(s.charAt(p1) - s.charAt(p2)) == 0 || Math.abs(s.charAt(p1) - s.charAt(p2)) == 32) {
                if (Math.abs(s.charAt(p1) - s.charAt(p2)) == 32) {
                    if (s.charAt(p1) >= '0' && s.charAt(p1) <= '9') {
                        return false;
                    } else if (s.charAt(p2) >= '0' && s.charAt(p2) <= '9') {
                        return false;
                    }
                }
                p2--;
                p1++;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean judgeChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
