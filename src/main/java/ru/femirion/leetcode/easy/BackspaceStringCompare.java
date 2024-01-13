package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/description/
 */
public class BackspaceStringCompare {

    /**
     * Runtime 2 ms Beats 55.25% of users with Java
     * Memory 41.96 MB Beats 8.78% of users with Java
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        String s1 = stackify(s, stack);
        stack.clear();
        String t1 = stackify(t, stack);
        return s1.equals(t1);
    }

    private String stackify(String t, Stack<Character> stack) {
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (stack.isEmpty()) {
                if (current != '#') {
                    stack.push(current);
                }
                continue;
            }
            if (current == '#') {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        return stack.toString();
    }


}
