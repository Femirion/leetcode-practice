package ru.femirion.leetcode.easy;

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 43.70 MB Beats 9.77%
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] tmp = new int[cost.length + 2];
        tmp[tmp.length - 1] = 0;

        for (int i = cost.length - 1; 0 <= i; i--) {
            tmp[i] = Math.min(tmp[i + 1], tmp[i + 2]) + cost[i];
        }

        return Math.min(tmp[0], tmp[1]);
    }
}
