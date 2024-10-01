package ru.femirion.leetcode.medium;

/**
 * 2149. Rearrange Array Elements by Sign
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */
public class RearrangeArrayElementsBySign {

    /**
     * Runtime 4 ms Beats 47.79%
     * Memory 85.96 MB Beats 5.07%
     */
    public int[] rearrangeArray(int[] nums) {
        int[] positiveNums = new int[nums.length / 2];
        int[] negativeNums = new int[nums.length / 2];
        int positiveIdx = 0;
        int negativeIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeNums[negativeIdx] = nums[i];
                negativeIdx++;
            } else {
                positiveNums[positiveIdx] = nums[i];
                positiveIdx++;
            }
        }

        positiveIdx = 0;
        negativeIdx = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = positiveNums[positiveIdx];
            result[i + 1] = negativeNums[negativeIdx];
            i++;
            positiveIdx++;
            negativeIdx++;
        }
        return result;
    }
}
