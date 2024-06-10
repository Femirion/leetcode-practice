package ru.femirion.leetcode.medium;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * Runtime 1 ms Beats 91.09% of users with Java
     * Memory 45.43 MB Beats 75.20% of users with Java
     */
    public int maxProfit(int[] prices) {
        int result = 0;

        boolean hasStock = false;
        int bayingPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int curPrice = prices[i];
            int nextDayPrice = prices[i + 1];

            if (curPrice < nextDayPrice) {
                if (!hasStock) {
                    hasStock = true;
                    bayingPrice = curPrice;
                }
            } else {
                if (hasStock) {
                    hasStock = false;
                    result = result + (curPrice - bayingPrice);
                }
            }
        }

        if (hasStock) {
            result = result + (prices[prices.length - 1] - bayingPrice);
        }

        return result;
    }
}
