package ru.femirion.leetcode.easy;

/**
 * 1539. Kth Missing Positive Number
 * https://leetcode.com/problems/kth-missing-positive-number/description/
 */
public class KthMissingPositiveNumber {

    /**
     * Runtime 1 ms Beats 26.53% of users with Java
     * Memory 42.65 MB Beats 55.67% of users with Java
     */
    public int findKthPositive(int[] arr, int k) {
        int n = 0;
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff != 1) {
                result = arr[i - 1];
                while (diff != 1) {
                    result++;
                    n++;
                    diff--;
                    if (n == k) {
                        return result;
                    }
                }
            }
        }

        if (result == 0) {
            return arr[arr.length - 1] + k;
        }

        return result;
    }
}
