package com.company;

/**
 * @program: 稀疏数组搜索
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 14:58
 **/
public class Solution {

    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int mid;
        int start = 0;
        int end = words.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int temp = mid;
            while (mid <= end && "".equals(words[mid])) {
                mid++;
            }
            if (mid > end) {
                end = temp - 1;
                continue;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
