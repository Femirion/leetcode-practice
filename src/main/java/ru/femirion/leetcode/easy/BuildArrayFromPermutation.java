package ru.femirion.leetcode.easy;

/**
 * 1920. Build Array from Permutation
 * https://leetcode.com/problems/build-array-from-permutation/
 */
public class BuildArrayFromPermutation {

    /**
     * Runtime 1 ms Beats 91.54%
     * Memory 44.9 MB Beats 6.9%
     */
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    /**
     * Runtime 1 ms Beats 91.54%
     * Memory 44.9 MB Beats 6.9%
     */
    public int[] buildArray1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    nums[j] = nums[nums[i]];
                }
            }
        }
        return nums;
    }

}
