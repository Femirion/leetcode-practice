package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {

    private static final String PARENT_PATH = "..";
    private static final String CURRENT_DIR_PATH = ".";
    private static final String EMPTY_PATH = "";

    /**
     * Runtime 4 ms Beats 83.64% of users with Java
     * Memory 43.27 MB Beats 59.71% of users with Java
     */
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        char cur;
        String tmpPath;
        for (int i = 0; i < path.length(); i++) {
            cur = path.charAt(i);

            if (cur == '/') {
                if (sb.isEmpty()) {
                    continue;
                }
                tmpPath = sb.toString();
                if (PARENT_PATH.equals(tmpPath)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (CURRENT_DIR_PATH.equals(tmpPath)) {
                    sb.setLength(0);
                    continue;
                } else {
                    if (!EMPTY_PATH.equals(tmpPath)) {
                        stack.push(tmpPath);
                    }
                }
                sb.setLength(0);
                continue;
            }

            sb.append(cur);
            if (i == path.length() - 1) {
                tmpPath = sb.toString();
                if (PARENT_PATH.equals(tmpPath)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (CURRENT_DIR_PATH.equals(tmpPath)) {
                    sb.setLength(0);
                    continue;
                } else if (!EMPTY_PATH.equals(tmpPath)) {
                    stack.push(tmpPath);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }


        return (result.length() == 0) ? "/" : result.toString();
    }
}
