package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class IntersectionOfTwoArrays {

    /**
     * Runtime 4 ms Beats 36.06% of users with Java
     * Memory 43.42 MB Beats 37.29% of users with Java
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            tmp.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (tmp.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }
}
