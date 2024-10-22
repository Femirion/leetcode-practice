package ru.femirion.leetcode.easy;

/**
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/description/
 */
public class RichestCustomerWealth {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.53 MB Beats 73.61%
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] acc : accounts) {
            int cur = 0;
            for (int num : acc) {
                cur = cur + num;
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}
