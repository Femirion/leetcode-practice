package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
 */
public class RemoveAllOccurrencesOfASubstring {

    /**
     * Runtime 35 ms Beats 5.13%
     * Memory 43.85 MB Beats 37.31%
     */
    public String removeOccurrences(String s, String part) {
        char[] chars = s.toCharArray();
        char[] partChars = part.toCharArray();
        char last = partChars[partChars.length - 1];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < chars.length; i++) {
            char cur = chars[i];

            if (cur != last) {
                stack.push(cur);
                continue;
            }
            if (stack.isEmpty()) {
                if (partChars.length == 1 && cur == partChars[0]) {
                    continue;
                }
                stack.push(cur);
                continue;
            }
            int prev = partChars.length - 2;
            char top = stack.peek();
            boolean partIsFound = true;
            StringBuilder tmpSb = new StringBuilder();
            while (0 <= prev) {
                if (stack.isEmpty()) {
                    partIsFound = false;
                    break;
                }
                top = stack.peek();
                char x = partChars[prev];
                if (partChars[prev] == top) {
                    tmpSb.append(partChars[prev]);
                    stack.pop();
                    prev--;
                } else {
                    partIsFound = false;
                    break;
                }
            }
            if (!partIsFound) {
                tmpSb.reverse();
                for (int j = 0; j < tmpSb.length(); j++) {
                    stack.push(tmpSb.charAt(j));
                }
                stack.push(cur);
            }

        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
