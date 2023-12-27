package ru.femirion.leetcode.easy;

/**
 * 2078. Two Furthest Houses With Different Colors
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */
public class TwoFurthestHousesWithDifferentColors {

    public int maxDistance(int[] colors) {
        int end = colors.length - 1;
        int p = 0;
        int result = 0;
        while (p < colors.length) {
            if (colors[0] != colors[p]) {
                result = Math.max(Math.max(result, p), Math.max(result, end - p));
            }
            p++;
        }
        return result;
    }
}
