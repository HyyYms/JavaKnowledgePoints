package com.company;

import java.util.HashMap;

/**
 * @program: 48、最长不含重复字符的子字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-10 09:01
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring3("au");
    }

    // 动态规划+双指针
    public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int j = -1;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j);
        }
        return res;
    }

    // 动态规划+线性遍历
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(i) != s.charAt(j)) {
                j--;
            }
            temp = temp < i - j ? temp + 1 : i - j;
            res = Math.max(res, temp);
        }
        return res;
    }

    // 动态规划+字典
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int temp = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            temp = temp < i - j ? temp + 1 : i - j;
            res = Math.max(res, temp);
        }
        return res;
    }

    // 使用一个数组记录当前字符的最长长度——线性遍历，时间复杂度：N^2
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] nums = new int[s.length()];
        nums[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!s.substring(i, i + 1).equals(s.substring(i - 1, i))) {
                boolean isHave = false;
                for (int j = nums[i - 1]; j > 0; j--) {
                    if (s.substring(i, i + 1).equals(s.substring(i - j, i - j + 1))) {
                        isHave = true;
                        nums[i] = j;
                        break;
                    }
                }
                if (!isHave) {
                    nums[i] = nums[i - 1] + 1;
                }
            } else {
                nums[i] = 1;
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
