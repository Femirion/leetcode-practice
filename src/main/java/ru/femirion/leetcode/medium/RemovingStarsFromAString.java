package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 2390. Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 */
public class RemovingStarsFromAString {

    /**
     * Runtime 72 ms Beats 59.93% of users with Java
     * Memory 45.48 MB Beats 84.98% of users with Java
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
