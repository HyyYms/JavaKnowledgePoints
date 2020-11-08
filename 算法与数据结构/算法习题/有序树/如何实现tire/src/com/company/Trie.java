package com.company;

import java.util.HashMap;

/**
 * @program: 如何实现tire
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 20:30
 **/
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");

    }

    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean hasWord = false;

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
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = current.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (!children.containsKey(wordArray[i])) {
                TrieNode child = new TrieNode(wordArray[i]);
                children.put(wordArray[i], child);
                current = child;
            } else {
                current = children.get(wordArray[i]);
            }
            children = current.children;
            if (i == wordArray.length - 1) {
                current.hasWord = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = current.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (children.containsKey(wordArray[i])) {
                current = children.get(wordArray[i]);
                children = current.children;
            } else {
                return false;
            }
        }
        return current.hasWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = current.children;
        char[] wordArray = prefix.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (children.containsKey(wordArray[i])) {
                current = children.get(wordArray[i]);
                children = current.children;
            } else {
                return false;
            }
        }
        return true;
    }
}
