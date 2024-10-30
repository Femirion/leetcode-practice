package ru.femirion.leetcode.easy;

/**
 * 3162. Find the Number of Good Pairs I
 * https://leetcode.com/problems/find-the-number-of-good-pairs-i/description/
 */
public class FindTheNumberOfGoodPairsI {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 43.28 MB Beats 7.09%
     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int result = 0;

        for (int j = 0; j < nums2.length; j++) {
            nums2[j] = nums2[j] * k;
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % nums2[j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
