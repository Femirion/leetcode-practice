package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2032. Two Out of Three
 * https://leetcode.com/problems/two-out-of-three/description/
 */
public class TwoOutOfThree {

    /**
     * Runtime 4 ms Beats 67.64% of users with Java
     * Memory 45.12 MB Beats 8.47% of users with Java
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> result = new HashSet<>();

        int[] arr = new int[100];

        for (int i = 0; i < nums1.length; i++) {
            if (arr[nums1[i]] == 0) {
                arr[nums1[i]]++;
            }
        }

        Set<Integer> wasAdded = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] == 0) {
                arr[nums2[i]]++;
                wasAdded.add(nums2[i]);
            } else {
                if (!wasAdded.contains(nums2[i])) {
                    result.add(nums2[i]);
                }
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            if (arr[nums3[i]] != 0) {
                result.add(nums3[i]);
            }
        }

        return new ArrayList<>(result);
    }
}
