package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 */
public class PerfectSquares {

    /**
     * Runtime 39 ms Beats 43.40%
     * Memory 42.39 MB Beats 79.86%
     */
    public int numSquares(int n) {
        int[] squares = new int[101];

        for (int i = 1; i <= n/2 + 1; i++) {
            int square = i * i;
            if (square <= n) {
                squares[i] = square;
            } else {
                break;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (squares[j] == 0 || i < squares[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - squares[j]]);
            }
        }

        return dp[n];
    }
}
