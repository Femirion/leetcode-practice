package ru.femirion.leetcode.easy;

/**
 * 1588. Sum of All Odd Length Subarrays
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/
 */
public class SumOfAllOddLengthSubarrays {

    /**
     * Runtime 2 ms Beats 55.13%
     * Memory 41.91 MB Beats 5.54%
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length + 1];

        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int sum = 0;
        for (int i = 1; i <= arr.length; i = i + 2) {
            for (int j = 0; j + i <= arr.length; j++) {
                sum = sum + prefix[j + i] - prefix[j];
            }
        }

        return sum;
    }
}
