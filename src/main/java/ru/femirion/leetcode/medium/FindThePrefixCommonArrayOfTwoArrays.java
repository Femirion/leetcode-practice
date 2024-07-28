package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
public class FindThePrefixCommonArrayOfTwoArrays {

    /**
     * Runtime 5 ms Beats 45.96%
     * Memory 45.15 MB Beats 90.00%
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setArr1 = new HashSet<>();
        Set<Integer> setArr2 = new HashSet<>();

        int[] result = new int[A.length];
        int prefixSize = 0;
        for(int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                prefixSize++;

            } else {
                if (setArr1.contains(B[i])) {
                    prefixSize++;
                }
                if (setArr2.contains(A[i])) {
                    prefixSize++;
                }
            }
            result[i] = prefixSize;
            setArr1.add(A[i]);
            setArr2.add(B[i]);
        }
        return result;
    }
}
