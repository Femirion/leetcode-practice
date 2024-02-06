package ru.femirion.leetcode.easy;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.09 MB Beats 54.30% of users with Java
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        int eP;
        int eQ;
        int w = 0;

        int[] arr = new int[nums1.length];
        while (p < m || q < n) {
            if (p == m) {
               eP = Integer.MAX_VALUE;
            } else {
                eP = nums1[p];
            }

            if (q == n) {
                eQ = Integer.MAX_VALUE;
            } else {
                eQ = nums2[q];
            }

            if (eP <= eQ) {
                arr[w] = eP;
                p++;
            } else {
                arr[w] = eQ;
                q++;
            }
            w++;
        }

        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }
    }

}
