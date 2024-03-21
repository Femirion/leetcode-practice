package ru.femirion.leetcode.easy;

/**
 * 2917. Find the K-or of an Array
 * https://leetcode.com/problems/find-the-k-or-of-an-array/description/
 *
 * #BitManipulation
 */
public class FindTheKOrOfAnArray {

    /**
     * Runtime 3 ms Beats 76.42% of users with Java
     * Memory 42.99 MB Beats 96.72% of users with Java
     */
    public int findKOr(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int currentCountBits = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    currentCountBits++;
                }
            }

            if (currentCountBits >= k) {
                result = result + (1 << i);
            }
        }
        return result;
    }
}
