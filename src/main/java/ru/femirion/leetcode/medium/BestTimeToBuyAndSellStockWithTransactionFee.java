package ru.femirion.leetcode.medium;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    private int[][] dp;

    /**
     * Runtime 41 ms Beats 8.14%
     * Memory 65.97 MB Beats 5.09%
     */
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length + 1][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        helper(prices, 0, 0, fee);
        return Math.max(dp[0][0], dp[0][1]);
    }

    private int helper(int[] prices, int idx, int taken, int fee) {
        if (dp[idx][taken] != -1) {
            return dp[idx][taken];
        }
        if (idx == prices.length && taken == 1) {
            return -1000000000;
        }
        if (idx == prices.length) {
            return 0;
        }
        if (taken == 1) {
            dp[idx][taken] = Math.max(helper(prices, idx + 1, 1, fee), prices[idx] - fee + helper(prices, idx + 1, 0, fee));
        } else {
            dp[idx][taken] = Math.max(helper(prices, idx + 1, 0, fee), -prices[idx] + helper(prices, idx + 1, 1, fee));
        }
        return dp[idx][taken];
    }
}
