package ru.femirion.leetcode.easy;

/**
 * 2427. Number of Common Factors
 * https://leetcode.com/problems/number-of-common-factors/
 */
public class NumberOfCommonFactors {

    /**
     * Runtime 1ms Beats 46.17% of users with Java
     * Memory 40.72MB eats 6.58% of users with Java
     */
    public int commonFactors(int a, int b) {
        int result = 0;
        for (int i = 1; i < Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }

}
