package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. Make Two Arrays Equal by Reversing Subarrays
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
 */
public class MakeTwoArraysEqualByReversingSubarrays {

    /**
     * Runtime 6 ms Beats 27.24%
     * Memory 44.64 MB Beats 16.05%
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int t : target) {
            nums.put(t, nums.getOrDefault(t, 0) + 1);
        }

        for (int a : arr) {
            Integer count = nums.get(a);
            if (count == null || count == 0) {
                return false;
            }
            if (count == 1) {
                nums.remove(a);
            } else {
                nums.put(a, count - 1);
            }
        }
        return nums.isEmpty();
    }

    /**
     * Runtime 1 ms Beats 99.98%
     * Memory 43.84 MB Beats 96.40%
     */
    public boolean canBeEqual1(int[] target, int[] arr) {
        int[] nums = new int[1001];

        for (int t : target) {
            nums[t]++;
        }

        for (int a : arr) {
            if (nums[a] == 0) {
                return false;
            } else {
                nums[a]--;
            }
        }
        for (int n : nums) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
