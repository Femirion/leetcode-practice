package ru.femirion.leetcode.easy;

/**
 * 2011. Final Value of Variable After Performing Operations
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/
 */
public class FinalValueOfVariableAfterPerformingOperations {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.84 MB Beats 23.15%
     */
    public int finalValueAfterOperations(String[] operations) {
        byte x = 0;
        for (String s : operations) {
            if (s.charAt(0) == '+' || s.charAt(2) == '+') {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
