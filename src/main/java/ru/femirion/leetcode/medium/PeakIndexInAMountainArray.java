package ru.femirion.leetcode.medium;

/**
 * 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 */
public class PeakIndexInAMountainArray {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 56.72 MB Beats 6.93% of users with Java
     */
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int currentIdx;
        int current;
        int prev;
        int next;

        while (start <= end) {
            currentIdx = start + ((end - start) / 2);
            current = arr[currentIdx];
            if (currentIdx == 0 || currentIdx == arr.length - 1) {
                return -1;
            }
            prev = arr[currentIdx - 1];
            next = arr[currentIdx + 1];
            if (prev < current && current > next) {
                return currentIdx;
            }
            if (prev < current) {
                start = currentIdx;
            }
            if (current < prev) {
                end = currentIdx;
            }
        }
        return -1;
    }
}
