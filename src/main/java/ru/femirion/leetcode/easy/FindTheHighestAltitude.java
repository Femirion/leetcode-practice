package ru.femirion.leetcode.easy;

/**
 * 1732. Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/description/
 */
public class FindTheHighestAltitude {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.10 MB Beats 75.69% of users with Java
     */
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
