package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 1874. Minimize Product Sum of Two Arrays
 * https://leetcode.com/problems/minimize-product-sum-of-two-arrays/description/
 */
public class MinimizeProductSumOfTwoArrays {

    /**
     * Runtime 23 ms Beats 73.26%
     * Memory 64.54 MB Beats 27.91%
     */
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int result = 0;

        for (int i = 0; i < nums1.length; i++) {
            result = result + nums1[i] * nums2[nums2.length - 1 - i];
        }

        return result;
    }
}
