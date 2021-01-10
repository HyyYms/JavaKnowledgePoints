package com.company;

import java.util.*;

/**
 * @program: 单词梯
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-07 17:46
 **/
public class Solution {

    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        int step = 1;
        dict.add(end);

        Set<String> duplicate = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();

        queue.offer(start);
        duplicate.add(start);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> list = getNext(word, dict);
                for (String nextWord : list) {
                    if (nextWord.equals(end)) {
                        return step;
                    }
                    if (duplicate.contains(nextWord)) {
                        continue;
                    }
                    queue.offer(nextWord);
                    duplicate.add(nextWord);
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String word, Set<String> dict) {
        List<String> list = new ArrayList<String>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < word.length(); j++) {
                String changeWord = changeWord(word, i, j);
                if (dict.contains(changeWord)) {
                    list.add(changeWord);
                }
            }
        }
        return list;
    }

    private String changeWord(String word, char i, int j) {
        char[] chars = word.toCharArray();
        chars[j] = i;
        return new String(chars);
    }

}
