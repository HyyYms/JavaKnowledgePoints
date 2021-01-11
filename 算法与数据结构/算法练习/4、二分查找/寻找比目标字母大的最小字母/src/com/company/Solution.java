package com.company;

/**
 * @program: 寻找比目标字母大的最小字母
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 20:27
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().nextGreatestLetter(new char[]{'c', 'f', 'h', 'j'}, 'g');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int mid;
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start];
    }
}
