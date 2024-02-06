package ru.femirion.leetcode.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Runtime 1 ms Beats 99.86% of users with Java
     * Memory 62.14 MB Beats 14.08% of users with Java
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            } else {
                int difference = currentPrice - minPrice;
                if (difference > result) {
                    result = difference;
                }
            }
        }

        return result;
    }

    /**
     * O(n^2)
     * Time Limit Exceeded
     */
    public int maxProfit1(int[] prices) {
        int buyDay = prices[0];
        int sellDay = prices[1];
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp > result) {
                    result = tmp;
                }
            }
        }

        return result;
    }
}
