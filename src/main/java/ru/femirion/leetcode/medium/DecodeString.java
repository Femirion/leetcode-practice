package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/description/
 */
public class DecodeString {

    /**
     * Runtime 2 ms Beats 40.44% of users with Java
     * Memory 41.05 MB Beats 95.82% of users with Java
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        char cur;
        char prev = ' ';
        int num = 0;
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (cur == ']') {
                prev = stack.pop();
                while (prev != '[') {
                    sb.insert(0, prev);
                    prev = stack.pop();
                }
                prev = stack.peek();
                while (isDigit(prev)) {
                    prev = stack.pop();
                    num = counter * (prev - '0') + num;
                    counter = counter * 10;
                    if (stack.isEmpty()) {
                        break;
                    }
                    prev = stack.peek();
                }

                String tmp = sb.toString();
                for (int j = 0; j < num * tmp.length(); j++) {
                    stack.push(tmp.charAt(j % tmp.length()));
                }
                sb = new StringBuilder();
                counter = 1;
                num = 0;
            } else {
                stack.push(cur);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    private boolean isDigit(char cur) {
        return '0' <= cur && cur <= '9';
    }
}
