package ru.femirion.leetcode.easy;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    /**
     * Runtime 2ms Beats 72.62%of users with Java
     * Memory 45.69MB Beats 26.13%of users with Java
     */
    public void moveZeroes(int[] nums) {
        int r = 0;
        int w = 0;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[r] == 0) {
                zeroCount++;
                r++;
            } else {
                nums[w] = nums[r];
                w++;
                r++;
            }
        }

        int i = nums.length - 1;
        while (zeroCount > 0) {
            nums[i] = 0;
            i--;
            zeroCount--;
        }
    }

}
