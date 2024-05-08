package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 888. Fair Candy Swap
 * https://leetcode.com/problems/fair-candy-swap/description/
 */
public class FairCandySwap {

    /**
     * Runtime 9 ms Beats 75.74% of users with Java
     * Memory 45.87 MB Beats 40.47% of users with Java
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = 0;
        int bobTotal = 0;
        Map<Integer, Integer> bobCandiesMap = new HashMap();

        for (int i = 0; i < aliceSizes.length; i++) {
            aliceTotal = aliceTotal + aliceSizes[i];
        }

        for (int i = 0; i < bobSizes.length; i++) {
            bobTotal = bobTotal + bobSizes[i];
            bobCandiesMap.put(bobSizes[i], 1);
        }

        int diff = (aliceTotal - bobTotal) / 2;

        for (int i = 0; i < aliceSizes.length; i++) {
            if (bobCandiesMap.containsKey(aliceSizes[i] - diff))
                return new int[] {aliceSizes[i], aliceSizes[i] - diff};
        }

        return new int[] {-1, -1};
    }

}
