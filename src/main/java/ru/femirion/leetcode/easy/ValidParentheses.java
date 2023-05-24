package ru.femirion.leetcode.easy;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
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
