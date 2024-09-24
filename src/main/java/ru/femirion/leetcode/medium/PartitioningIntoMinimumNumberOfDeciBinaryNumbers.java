package ru.femirion.leetcode.medium;

/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    /**
     * Runtime 5 ms Beats 77.75%
     * Memory 45.03 MB Beats 64.63%
     */
    public int minPartitions(String n) {
        int result = 0;

        for (char c : n.toCharArray()) {
            result = Math.max(result, c - '0');
        }

        return result;
    }
}
