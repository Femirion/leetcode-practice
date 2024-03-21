package ru.femirion.leetcode.easy;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */
public class NumberOfStepsToReduceANumberToZero {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.21 MB Beats 68.13% of users with Java
     */
    public int numberOfSteps(int num) {
        int result = 0;

        while (num != 0) {
            if ((num & 1) != 1) {
                num = num >> 1;
            } else {
                num = num ^ 1;
            }
            result++;
        }

        return result;
    }
}
