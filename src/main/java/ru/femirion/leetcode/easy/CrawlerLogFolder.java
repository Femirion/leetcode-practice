package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 1598. Crawler Log Folder
 * https://leetcode.com/problems/crawler-log-folder/description/
 */
public class CrawlerLogFolder {

    /**
     * Runtime 1 ms Beats 98.83%
     * Memory 42.33 MB Beats 17.12%
     */
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String curLog : logs) {
            if ("./".equals(curLog)) {
                continue;
            }

            if ("../".equals(curLog)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(curLog);
        }

        return stack.size();
    }
}
