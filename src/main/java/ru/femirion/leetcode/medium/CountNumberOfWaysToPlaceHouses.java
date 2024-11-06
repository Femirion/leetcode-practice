package ru.femirion.leetcode.medium;

/**
 * 2320. Count Number of Ways to Place Houses
 * https://leetcode.com/problems/count-number-of-ways-to-place-houses/description/
 */

public class CountNumberOfWaysToPlaceHouses {

    /**
     * Runtime 6 ms Beats 63.16%
     * Memory 43.90 MB Beats 45.21%
     */
    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007L;
        }

        return (int) ((dp[n] * dp[n]) % 1000000007L);
    }
}
