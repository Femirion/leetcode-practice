package ru.femirion.leetcode.easy;

/**
 * 1854. Maximum Population Year
 * https://leetcode.com/problems/maximum-population-year/description/
 */
public class MaximumPopulationYear {

    /**
     * Runtime 1 ms Beats 45.53%
     * Memory 41.41 MB Beats 71.24%
     */
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];

        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0] - 1950;
            int death = logs[i][1] - 1950;
            for (int j = birth; j < death; j++) {
                years[j]++;
            }
        }

        int max = years[0];
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            if (max < years[i]) {
                max = years[i];
                result = i;
            }
        }
        return result + 1950;
    }
}
