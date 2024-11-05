package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 2000. Reverse Prefix of Word
 * https://leetcode.com/problems/reverse-prefix-of-word/description/
 */
public class ReversePrefixOfWord {

    /**
     * Runtime 2 ms Beats 22.98%
     * Memory 41.58 MB Beats 65.88%
     */
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        boolean isFound = false;
        for (; i < word.length(); i++) {
            char c = word.charAt(i);
            stack.push(c);
            if (c == ch) {
                i++;
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            return word;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        for (; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }

    /**
     * Runtime 1 ms Beats 58.50%
     * Memory 41.59 MB Beats 65.88%
     */
    public String reversePrefix2(String word, char ch) {
        int i = 0;
        for (; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                break;
            }
        }

        if (i == word.length()) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = i; 0 <= j; j--) {
            sb.append(word.charAt(j));
        }

        i++;
        for (; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.39 MB Beats 89.29%
     */
    public String reversePrefix3(String word, char ch) {
        int pos = word.indexOf(ch);
        if (pos == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        return sb
                .append(word, 0, pos + 1)
                .reverse()
                .append(word.substring(pos + 1))
                .toString();
    }
}
