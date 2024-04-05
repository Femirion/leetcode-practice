package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 1544. Make The String Great
 * https://leetcode.com/problems/make-the-string-great/description/
 */
public class MakeTheStringGreat {

    /**
     * Runtime 3 ms Beats 61.07% of users with Java
     * Memory 41.98 MB Beats 77.06% of users with Java
     */
    public String makeGood(String s) {
        char[] arr = s.toCharArray();

        char cur;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            cur = arr[i];
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top != cur && Character.toLowerCase(top) == Character.toLowerCase(cur)) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
