package ru.femirion.leetcode.easy;

/**
 * 1534. Count Good Triplets
 * https://leetcode.com/problems/count-good-triplets/description/
 */
public class CountGoodTriplets {

    /**
     * Runtime 13 ms Beats 56.44%
     * Memory 41.33 MB Beats 59.44%
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a < Math.abs(arr[i] - arr[j])) {
                        continue;
                    }

                    if (b < Math.abs(arr[j] - arr[k])) {
                        continue;
                    }

                    if (c < Math.abs(arr[i] - arr[k])) {
                        continue;
                    }

                    result++;
                }
            }
        }

        return result;
    }


    /**
     * Runtime 10 ms Beats 77.35%
     * Memory 41.71 MB Beats 16.26%
     */
    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (a < Math.abs(arr[i] - arr[j])) {
                    continue;
                }

                for (int k = j + 1; k < n; k++) {
                    if (b < Math.abs(arr[j] - arr[k])) {
                        continue;
                    }

                    if (c < Math.abs(arr[i] - arr[k])) {
                        continue;
                    }

                    result++;
                }
            }
        }

        return result;
    }
}
