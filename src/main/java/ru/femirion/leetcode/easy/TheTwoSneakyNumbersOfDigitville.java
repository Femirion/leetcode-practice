package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 3289. The Two Sneaky Numbers of Digitville
 * https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/
 */
public class TheTwoSneakyNumbersOfDigitville {

    /**
     * Runtime 1 ms Beats 99.98%
     * Memory 44.48 MB Beats 80.86%
     */
    public int[] getSneakyNumbers2(int[] nums) {
        int[] result = new int[2];

        int[] existedNums = new int[100];

        int resultIdx = 0;
        for (int num : nums) {
            if (existedNums[num] != 0) {
                result[resultIdx] = num;
                resultIdx++;
                if (resultIdx == 2) {
                    return result;
                }
            } else {
                existedNums[num] = 1;
            }
        }
        return result;
    }

    /**
     * Runtime 2 ms Beats 71.57%
     * Memory 44.44 MB Beats 80.86%
     */
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];

        Set<Integer> existedNums = new HashSet<>();

        int resultIdx = 0;
        for (int num : nums) {
            if (existedNums.contains(num)) {
                result[resultIdx] = num;
                resultIdx++;
                if (resultIdx == 2) {
                    return result;
                }
            } else {
                existedNums.add(num);
            }
        }
        return result;
    }
}
