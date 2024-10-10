package ru.femirion.leetcode.easy;

/**
 * 2769. Find the Maximum Achievable Number
 * https://leetcode.com/problems/find-the-maximum-achievable-number/description/
 */
public class FindTheMaximumAchievableNumber {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 41.39 MB Beats 58.82%
     */
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }
}
