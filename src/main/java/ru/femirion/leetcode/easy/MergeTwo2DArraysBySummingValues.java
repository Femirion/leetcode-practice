package ru.femirion.leetcode.easy;

/**
 * 2570. Merge Two 2D Arrays by Summing Values
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
 */
public class MergeTwo2DArraysBySummingValues {

    /**
     * Runtime 1 ms Beats 87.11%
     * Memory 44.98 MB Beats 88.61%
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int size = 0;
        int[] tmp = new int[Math.max(nums1[nums1.length - 1][0], nums2[nums2.length - 1][0]) + 1];

        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
            if (i < nums1.length) {
                if (tmp[nums1[i][0]] == 0) {
                    size++;
                }
                tmp[nums1[i][0]] += nums1[i][1];
            }
            if (i < nums2.length) {
                if (tmp[nums2[i][0]] == 0) {
                    size++;
                }
                tmp[nums2[i][0]] += nums2[i][1];
            }
        }

        int[][] result = new int[size][2];
        int idx = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) {
                result[idx][0] = i;
                result[idx][1] = tmp[i];
                idx++;
            }
        }
        return result;
    }
}
