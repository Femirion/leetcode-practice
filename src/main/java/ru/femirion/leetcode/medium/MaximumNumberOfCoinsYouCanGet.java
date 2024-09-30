package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 1561. Maximum Number of Coins You Can Get
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
 */
public class MaximumNumberOfCoinsYouCanGet {

    /**
     * Runtime 26 ms Beats 92.27%
     * Memory 56.52 MB Beats 33.18%
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left = 0;
        int right = piles.length - 1;

        int result = 0;
        while (left < right) {
            right--;
            result = result + piles[right];
            right--;
            left++;
        }
        return result;
    }
}
