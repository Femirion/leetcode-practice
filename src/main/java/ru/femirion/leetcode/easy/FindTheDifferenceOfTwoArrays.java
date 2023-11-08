package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2215. Find the Difference of Two Arrays
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays {

    /**
     * Runtime 2ms Beats 38.14% of users with Java
     * Memory 44.18MB Beats 88.52% of users with Java
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> r1 = new HashSet<>();
        Set<Integer> r2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (!s2.contains(nums1[i])) {
                r2.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!s1.contains(nums2[i])) {
                r1.add(nums2[i]);
            }
        }
        result.add(new ArrayList<>(r2));
        result.add(new ArrayList<>(r1));

        return result;
    }

    /**
     * Runtime 14ms Beats 28.26% of users with Java
     * Memory  44.10MB Beats 88.52% of users with Java
     */
    public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int[][] numbers = new int[2001][2];

        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            numbers[val + 1000][0] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            int val = nums2[i];
            numbers[val + 1000][1] = 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            int v1 = numbers[i][0];
            int v2 = numbers[i][1];
            if (v1 == 1 && v2 != 1) {
                r2.add(i - 1000);
            }
            if (v2 == 1 && v1 != 1) {
                r1.add(i - 1000);
            }
        }
        result.add(r2);
        result.add(r1);

        return result;
    }

}
