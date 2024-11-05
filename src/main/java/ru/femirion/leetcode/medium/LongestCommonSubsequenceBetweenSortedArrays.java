package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1940. Longest Common Subsequence Between Sorted Arrays
 * https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/description/
 */
public class LongestCommonSubsequenceBetweenSortedArrays {

    /**
     * Runtime 40 ms Beats 16.67%
     * Memory 45.51 MB Beats 52.38%
     */
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result = new ArrayList<>();

        int[] pointers = new int[arrays.length];
        for (int i = 0; ; i++) {
            int min = arrays[0][pointers[0]];
            int minPointer = 0;
            boolean hasDiff = false;
            for (int j = 0; j < pointers.length; j++) {
                if (arrays[j].length == pointers[j]) {
                    return result;
                }
                if (j != 0 && arrays[j][pointers[j]] != arrays[j - 1][pointers[j - 1]]) {
                    hasDiff = true;
                }
                if (arrays[j][pointers[j]] < min) {
                    min = arrays[j][pointers[j]];
                    minPointer = j;
                }
            }
            if (!hasDiff) {
                result.add(min);
                for (int j = 0; j < pointers.length; j++) {
                    pointers[j]++;
                    if (pointers[j] == arrays[j].length) {
                        return result;
                    }
                }
            } else {
                pointers[minPointer]++;
                if (pointers[minPointer] == arrays[minPointer].length) {
                    return result;
                }
            }
        }
    }
}
