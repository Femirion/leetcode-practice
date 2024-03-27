package ru.femirion.leetcode.easy;

/**
 * 2706. Buy Two Chocolates
 * https://leetcode.com/problems/buy-two-chocolates/description/
 */
public class BuyTwoChocolates {

    /**
     * Runtime 1 ms Beats 100.00% of users with Java
     * Memory 44.09 MB Beats 80.20% of users with Java
     */
    public int buyChoco(int[] prices, int money) {
        int price1 = 101;
        int price2 = 101;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < price1) {
                price2 = price1;
                price1 = prices[i];
                continue;
            }
            if (prices[i] < price2) {
                price2 = prices[i];
            }
        }
        int result = money - price1 - price2;
        if (result < 0 || price1 == 101 || price2 == 101) {
            return money;
        }
        return result;
    }
}
