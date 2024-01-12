package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * Runtime 29 ms Beats 57.72% of users with Java
     * Memory 45.26 MB Beats 42.82% of users with Java
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }
            char top = stack.peek();
            if (current == top) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
