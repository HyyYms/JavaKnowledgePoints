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

    // 筛选和判断
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String sbReverse = sb.reverse().toString();
        return sb.toString().equals(sbReverse);
    }

    // 双指针——借助辅助空间
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left <= right) {
            char cLeft = sb.charAt(left);
            char cRight = sb.charAt(right);
            if (cLeft != cRight) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 双指针——不借助辅助空间
    public boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
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
            if (p1 <= p2) {
                if (Math.abs(s.charAt(p1) - s.charAt(p2)) == 0 || Math.abs(s.charAt(p1) - s.charAt(p2)) == 32) {
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
