package com.company;

import sun.java2d.opengl.WGLSurfaceData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: 如何实现trie
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-10 11:58
 **/
public class WordDictionary {

    private class TrieNode {
        char c;
        boolean hasWord;
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (children.containsKey(wordArray[i])) {
                current = children.get(wordArray[i]);
                children = current.children;
            } else {
                TrieNode child = new TrieNode(wordArray[i]);
                children.put(wordArray[i], child);
                current = child;
                children = current.children;
            }
            if (i == wordArray.length - 1) {
                current.hasWord = true;
            }
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    private boolean searchWord(String word, Integer num, TrieNode root) {
        if (num == word.length()) {
            return root.hasWord;
        }
        TrieNode current = root;
        HashMap<Character, TrieNode> children = root.children;
        char[] wordArray = word.toCharArray();
        if (wordArray[num] != '.') {
            if (!children.containsKey(wordArray[num])) {
                return false;
            } else {
                return searchWord(word, num + 1, children.get(wordArray[num]));
            }
        } else {
            List<Character> childrenArray = new ArrayList<>();
            for (char j = 'a'; j <= 'z'; j++) {
                if (children.containsKey(j)) {
                    childrenArray.add(j);
                }
            }
            for (Character ch : childrenArray) {
                if (searchWord(word, num + 1, children.get(ch))) {
                    return true;
                }
            }
            return false;
        }
    }
}
