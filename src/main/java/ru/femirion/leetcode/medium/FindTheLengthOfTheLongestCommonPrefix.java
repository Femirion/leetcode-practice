package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 3043. Find the Length of the Longest Common Prefix
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
 */
public class FindTheLengthOfTheLongestCommonPrefix {

    /**
     * Runtime 150 ms Beats 28.46%
     * Memory 55.26 MB Beats 84.54%
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for (int num : arr1) {
            fillTrie(trie, num);
        }

        int maxPrefix = 0;
        int curPrefix = 0;
        for (int num : arr2) {
            Stack<Integer> stack = new Stack<>();
            while (0 < num) {
                stack.push(num % 10);
                num = num / 10;
            }
            Trie curTrie = trie;
            while(!stack.isEmpty()) {
                int n = stack.pop();
                if (curTrie.nodes[n] != null) {
                    curPrefix++;
                    curTrie = curTrie.nodes[n];
                } else {
                    stack = new Stack();
                    break;
                }
            }
            maxPrefix = Math.max(maxPrefix, curPrefix);
            curPrefix = 0;
        }
        return maxPrefix;
    }

    private Trie fillTrie(Trie trie, int number) {
        if (number == 0) {
            Trie t = new Trie();
            trie.nodes[0] = t;
            return trie;
        }
        Stack<Integer> stack = new Stack<>();
        while (0 < number) {
            stack.push(number % 10);
            number = number / 10;
        }
        Trie curTrie = trie;
        while(!stack.isEmpty()) {
            Trie t = new Trie();
            int num = stack.pop();
            if (curTrie.nodes[num] == null) {
                curTrie.nodes[num] = t;
            }
            curTrie = curTrie.nodes[num];
        }
        return trie;
    }

    private static class Trie {
        Trie[] nodes = new Trie[10];
    }
}
