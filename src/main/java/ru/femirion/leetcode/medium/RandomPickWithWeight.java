package ru.femirion.leetcode.medium;

import java.util.Random;

/**
 * 528. Random Pick with Weight
 * https://leetcode.com/problems/random-pick-with-weight/description/
 */
public class RandomPickWithWeight {

    private int[] prefixSums;
    private int sum;
    private Random rnd;

    /**
     * Runtime 195 ms Beats 5.06%
     * Memory 49.46 MB Beats 93.52%
     */
    public RandomPickWithWeight(int[] w) {
        prefixSums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum = sum + w[i];
            prefixSums[i] = sum;
        }
        rnd = new Random();
    }

    public int pickIndex() {
        int rndNumber = rnd.nextInt(sum) + 1;

        int start = 0;
        int end = prefixSums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (prefixSums[mid] == rndNumber) {
                return mid;
            }
            if (rndNumber < prefixSums[mid]) {
                end = mid - 1;
            } else {
                start = start + 1;
            }
        }
        return start;
    }
}
