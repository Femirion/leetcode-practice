package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    /**
     * Runtime 2 ms Beats 50.42%
     * Memory 41.36 MB Beats 83.00%
     */
    public String reverseParentheses(String s) {
        Stack<Integer> parStack = new Stack<>();
        char[] chars = s.toCharArray();
        int parCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                parStack.push(i);
                parCount++;
                continue;
            }
            if (chars[i] == ')') {
                int start = parStack.pop() + 1;
                int end = i - 1;
                while (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    end--;
                    start++;
                }
                continue;
            }
        }
        char[] result = new char[chars.length - parCount * 2];
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < chars.length; readIdx++) {
            if (chars[readIdx] != ')' && chars[readIdx] != '(') {
                result[writeIdx] = chars[readIdx];
                writeIdx++;
            }
        }
        return new String(result);
    }
}
