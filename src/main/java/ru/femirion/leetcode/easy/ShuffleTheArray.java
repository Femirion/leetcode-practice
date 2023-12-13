package ru.femirion.leetcode.easy;

/**
 * 1470. Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleTheArray {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 43.81MB Beats 40.95%of users with Java
     */
    public int[] shuffle(int[] nums, int n) {
        int x = 0;
        int y = n;
        int i = 0;
        int[] result = new int[nums.length];
        while (y < nums.length) {
            result[i] = nums[x];
            result[i + 1] = nums[y];
            y++;
            x++;
            i = i + 2;
        }
        return result;
    }
}
