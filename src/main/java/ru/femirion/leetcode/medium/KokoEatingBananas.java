package ru.femirion.leetcode.medium;

import java.util.Arrays;

/** 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas {

    /**
     * Runtime 17 ms Beats 65.92% of users with Java
     * Memory 45.02 MB Beats 49.40% of users with Java
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            if (piles[0] % h == 0) {
                return piles[0] / h;
            } else {
                return piles[0] / h + 1;
            }
        }

        Arrays.sort(piles);

        int start = 1;
        int end = piles[piles.length - 1];
        int minSpeed = piles[piles.length - 1];
        int currSpeed;

        while (start <= end) {
            currSpeed = start + ((end - start) / 2);
            if (canKokoEatAllBananas(piles, h, currSpeed)) {
                if (currSpeed < minSpeed) {
                    minSpeed = currSpeed;
                }
                end = currSpeed - 1;
            } else {
                start = currSpeed + 1;
            }
        }
        return minSpeed;
    }

    private boolean canKokoEatAllBananas(int[] piles, int h, int speed) {
        long curTime = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] <= speed) {
                curTime++;
            } else {
                if (piles[i] % speed == 0) {
                    curTime = curTime + (piles[i] / speed);
                } else {
                    curTime = curTime + (piles[i] / speed) + 1;
                }
            }
        }
        return curTime <= h;
    }
}
