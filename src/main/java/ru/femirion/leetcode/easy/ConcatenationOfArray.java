package ru.femirion.leetcode.easy;

/**
 * 1929. Concatenation of Array
 * https://leetcode.com/problems/concatenation-of-array/description/
 */
public class ConcatenationOfArray {

    /**
     * Runtime 1 ms Beats 96.18%
     * Memory 45.27 MB Beats 51.81%
     */
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
