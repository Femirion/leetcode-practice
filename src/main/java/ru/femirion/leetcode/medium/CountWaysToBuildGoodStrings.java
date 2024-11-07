package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 2466. Count Ways To Build Good Strings
 * https://leetcode.com/problems/count-ways-to-build-good-strings/description/
 */
public class CountWaysToBuildGoodStrings {

    private int[] dp;

    /**
     * Runtime 9 ms Beats 55.10%
     * Memory 54.86 MB Beats 32.01%
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return dfs(0, low, high, zero, one);
    }

    private int dfs(int length, int low, int high, int zero, int one) {
        if (high < length) {
            return 0;
        }

        if (dp[length] != -1) {
            return dp[length];
        }

        int count = 0;
        if (low <= length) {
            count = 1;
        }
        count = count + dfs(length + zero, low, high, zero, one);
        count = count + dfs(length + one, low, high, zero, one);
        dp[length] = count % 1000000007;

        return dp[length];
    }
}
