package ru.femirion.leetcode.easy;

import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    /**
     * Runtime: 3 ms, faster than 48.49% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.2 MB, less than 41.24% of Java online submissions for Valid Parentheses.
     */
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            var current = s.charAt(i);
            switch (current) {
                case '(':
                case '{':
                case '[': {
                    list.addFirst(current);
                    break;
                }
                case ')': {
                    if (list.isEmpty()) {
                        return false;
                    }
                    var element = list.removeFirst();
                    if (element != '(') {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (list.isEmpty()) {
                        return false;
                    }
                    var element = list.removeFirst();
                    if (element != '{') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (list.isEmpty()) {
                        return false;
                    }
                    var element = list.removeFirst();
                    if (element != '[') {
                        return false;
                    }
                    break;
                }
            }
        }
        return list.isEmpty();
    }
}
