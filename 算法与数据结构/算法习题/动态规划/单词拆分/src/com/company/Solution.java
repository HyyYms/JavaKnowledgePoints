package com.company;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: 单词拆分
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-13 21:28
 **/
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new LinkedHashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        int maxWordLength = getMaxWordLength(dict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= maxWordLength && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[s.length()];
    }

    private int getMaxWordLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}
