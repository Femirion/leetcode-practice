package ru.femirion.leetcode.easy;

/**
 * 1614. Maximum Nesting Depth of the Parentheses
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */
public class MaximumNestingDepthOfTheParentheses {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.38 MB Beats 52.50% of users with Java
     */
    public int maxDepth(String s) {
        char[] arr = s.toCharArray();
        int maxDepth = 0;
        int curDepth = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (cur == '(') {
                curDepth++;
                if (curDepth > maxDepth) {
                    maxDepth = curDepth;
                }
                continue;
            }
            if (cur == ')') {
                curDepth--;
            }
        }
        return maxDepth;
    }
}
