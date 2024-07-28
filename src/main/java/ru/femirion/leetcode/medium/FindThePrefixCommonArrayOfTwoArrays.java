package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
public class FindThePrefixCommonArrayOfTwoArrays {

    /**
     * Runtime 2 ms Beats 93.60%
     * Memory 45.40 MB Beats 58.99%
     */
    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int[] setArr1 = new int[A.length];
        int[] setArr2 = new int[B.length];

        int[] result = new int[A.length];
        int prefixSize = 0;
        for(int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                prefixSize++;

            } else {
                if (setArr1[B[i] - 1] == 1) {
                    prefixSize++;
                }
                if (setArr2[A[i] - 1] == 1) {
                    prefixSize++;
                }
            }
            result[i] = prefixSize;
            setArr1[A[i] - 1] = 1;
            setArr2[B[i] - 1] = 1;
        }
        return result;
    }

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
