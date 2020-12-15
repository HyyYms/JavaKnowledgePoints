package com.company;

/**
 * @program: 实现 strStr()
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-15 13:07
 **/
public class Solution4 {

    public static void main(String[] args) {
        new Solution4().strStr("aaaa",
                "bba");
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int p1 = 0;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        while (p1 < haystackArray.length - needleArray.length + 1) {
            while (p1 < haystackArray.length - needleArray.length + 1 &&
                    haystackArray[p1] != needleArray[0]) {
                p1++;
            }
            int curLen = 0;
            int p2 = 0;
            while (p2 < needleArray.length && p1 < haystackArray.length
                    && haystackArray[p1] == needleArray[p2]) {
                p1++;
                p2++;
                curLen++;
            }
            if (curLen == needleArray.length) {
                return p1 - p2;
            }
            p1 = p1 - curLen + 1;
        }
        return -1;
    }
}
