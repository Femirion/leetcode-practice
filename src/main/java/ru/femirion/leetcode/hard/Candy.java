package ru.femirion.leetcode.hard;

import java.util.Arrays;

/**
 * 135. Candy
 * https://leetcode.com/problems/candy/description/
 */
public class Candy {

    /**
     * Runtime 3 ms Beats 83.63%
     * Memory 45.18 MB Beats 91.54%
     */
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                result[i] = result[i - 1] + 1;
            }
        }

        int count = result[ratings.length - 1];
        for (int i = ratings.length - 2; 0 <= i; i--) {
            if (ratings[i + 1] < ratings[i] && result[i] <= result[i + 1]) {
                result[i] = result[i] + (result[i + 1] - result[i]) + 1;
            }
            count = count + result[i];
        }

        return count;
    }
}
