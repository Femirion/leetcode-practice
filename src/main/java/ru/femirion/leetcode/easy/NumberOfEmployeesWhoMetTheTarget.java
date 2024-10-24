package ru.femirion.leetcode.easy;

/**
 * 2798. Number of Employees Who Met the Target
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
 */
public class NumberOfEmployeesWhoMetTheTarget {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.25 MB Beats 51.76%
     */
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;

        for (int h : hours) {
            if (target <=h) {
                result++;
            }
        }

        return result;
    }
}
