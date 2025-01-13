package ru.femirion.leetcode.medium;

/**
 * 3400. Maximum Number of Matching Indices After Right Shifts
 * https://leetcode.com/problems/maximum-number-of-matching-indices-after-right-shifts/description/
 */
public class MaximumNumberOfMatchingIndicesAfterRightShifts {

    /**
     * Runtime 89 ms Beats 13.49%
     * Memory 45.27 MB Beats 50.00%
     */
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            int p = 0;
            int q = i;
            int curResult = 0;

            while (p < nums1.length) {
                if (nums1[p] == nums2[q % nums2.length]) {
                    curResult++;
                    result = Math.max(result, curResult);
                }
                p++;
                q++;
            }
        }

        return result;
    }
}
