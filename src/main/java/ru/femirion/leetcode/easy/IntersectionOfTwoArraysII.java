package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class IntersectionOfTwoArraysII {

    /**
     * Runtime 2 ms Beats 90.06%
     * Memory 43.36 MB Beats 22.31%
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        int[] existedNums = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            existedNums[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (0 < existedNums[nums2[i]]) {
                result.add(nums2[i]);
                existedNums[nums2[i]]--;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
