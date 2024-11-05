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
}
