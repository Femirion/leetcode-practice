package ru.femirion.leetcode.medium;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 57.58 MB Beats 18.55% of users with Java
     */
    public void rotate(int[] nums, int k) {
        int size = nums.length;

        if (k > size) {
            k = k % size;
        }

        rotateArray(nums, 0, size - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, size - 1);
    }

    private void rotateArray(int[] array, int start, int finish) {
        int tmp;
        while (start < finish) {
            tmp = array[start];
            array[start] = array[finish];
            array[finish] = tmp;
            start++;
            finish--;
        }
    }
}
