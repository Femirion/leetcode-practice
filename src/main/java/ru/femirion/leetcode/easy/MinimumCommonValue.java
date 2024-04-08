package ru.femirion.leetcode.easy;

/**
 * 2540. Minimum Common Value
 * https://leetcode.com/problems/minimum-common-value/description/
 */
public class MinimumCommonValue {

    /**
     * Runtime 2 ms Beats 81.04% of users with Java
     * Memory 62.60 MB Beats 59.09% of users with Java
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int p = 0;
        int q = 0;

        while (p < nums1.length && q < nums2.length) {
            int pV = nums1[p];
            int qV = nums2[q];

            if (pV == qV) {
                return pV;
            }

            if (pV < qV) {
                p++;
            } else {
                q++;
            }
        }
        return -1;
    }
}
