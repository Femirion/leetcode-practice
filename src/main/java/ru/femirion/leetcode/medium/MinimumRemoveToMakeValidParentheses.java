package ru.femirion.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 */
public class MinimumRemoveToMakeValidParentheses {

    /**
     * Runtime 23 ms Beats 46.59%
     * Memory 45.21 MB Beats 77.12%
     */
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int countOfParentheses = 0;

        Stack<Character> charStack = new Stack<>();
        Deque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == '(') {
                charStack.push(cur);
                indexStack.push(i);
                continue;
            }
            if (cur == ')') {
                if (charStack.isEmpty()) {
                    charStack.push(cur);
                    indexStack.push(i);
                } else {
                    char top = charStack.peek();
                    if (top == '(') {
                        charStack.pop();
                        indexStack.pop();
                    } else {
                        charStack.push(cur);
                        indexStack.push(i);
                    }
                }
            }
        }

        if (indexStack.isEmpty()) {
            return s;
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(!indexStack.isEmpty()) {
            int idx = indexStack.removeLast();
            for (; i < idx; i++) {
                sb.append(chars[i]);
            }
            i++;
        }
        for (; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
