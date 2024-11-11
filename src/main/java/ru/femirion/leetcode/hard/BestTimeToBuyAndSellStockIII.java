package ru.femirion.leetcode.hard;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class BestTimeToBuyAndSellStockIII {

    private int[][][] dp;

    /**
     * Runtime 116 ms Beats 20.94%
     * Memory 81.76 MB Beats 9.26%
     */
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2][3];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = -1;
            dp[i][0][1] = -1;
            dp[i][0][2] = -1;
            dp[i][1][0] = -1;
            dp[i][1][1] = -1;
            dp[i][1][2] = -1;
        }
        return findMaxProfit(prices, 0, 0, 2);
    }

    private int findMaxProfit(int[] prices, int idx, int taken, int counter) {
        if (counter == -1) {
            return -1000000001;
        }

        if (dp[idx][taken][counter] != -1) {
            return dp[idx][taken][counter];
        }

        if (idx == prices.length) {
            if (taken == 1) {
                return -1000000001;
            } else {
                return 0;
            }
        }

        if (taken == 1) {
            dp[idx][taken][counter] = Math.max(findMaxProfit(prices, idx + 1, 1, counter), prices[idx] + findMaxProfit(prices, idx + 1, 0, counter));
        } else {
            dp[idx][taken][counter] = Math.max(findMaxProfit(prices, idx + 1, 0, counter), findMaxProfit(prices, idx + 1, 1, counter - 1) - prices[idx]);
        }

        return dp[idx][taken][counter];
    }
}
