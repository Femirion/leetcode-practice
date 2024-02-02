package ru.femirion.leetcode.easy;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SquaresOfASortedArray {

    /**
     * Runtime 1 ms Beats 100.00% of users with Java
     * Memory 47.64 MB Beats 5.19% of users with Java
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 1 || nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
        }

        int q = i - 1;
        int p = i;


        int pos = 0;
        while(q >= 0 || p < nums.length) {
            int pValue;
            if (p >= nums.length) {
                pValue = Integer.MAX_VALUE;
            } else {
                pValue = nums[p];
            }

            int qValue;
            if (q < 0) {
                qValue = Integer.MAX_VALUE;
            } else {
                qValue = nums[q];
            }

            if (Math.abs(qValue) >= Math.abs(pValue)) {
                result[pos] = pValue * pValue;
                p++;
                pos++;
            } else {
                result[pos] = qValue * qValue;
                q--;
                pos++;
            }
        }
        return result;
    }

}
