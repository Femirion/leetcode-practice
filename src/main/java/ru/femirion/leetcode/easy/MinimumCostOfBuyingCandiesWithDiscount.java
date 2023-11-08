package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2144. Minimum Cost of Buying Candies With Discount
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 */
public class MinimumCostOfBuyingCandiesWithDiscount {

    /**
     * Runtime 2ms Beats 97.08% of users with Java
     * Memory 41.05MB Beats 46.35% of users with Java
     */
    public int minimumCost(int[] cost) {
        int result = 0;
        Arrays.sort(cost);
        for (int i = cost.length - 1; i >= 0; i--) {
            int first = cost[i];
            i--;
            result = result + first;
            if (i < 0) {
                break;
            }
            int second = cost[i];
            i--;
            result = result + second;
        }
        return result;
    }
}
