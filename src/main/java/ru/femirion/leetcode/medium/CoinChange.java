package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 322. Coin Change
 */
public class CoinChange {

    /**
     * Runtime 15 ms Beats 78.93%
     * Memory 44.04 MB Beats 80.80%
     */
    public int coinChange(int[] coins, int amount) {
        int[] min = new int[amount + 1];
        Arrays.fill(min, amount + 1);
        min[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    min[i] = Math.min(min[i], 1 + min[i - coins[j]]);
                }
            }
        }

        return min[amount] != amount + 1 ?  min[amount] : -1;
    }
}
