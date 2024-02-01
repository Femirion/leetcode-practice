package ru.femirion.leetcode.easy;

/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/description/
 */
public class SortArrayByParity {

    /**
     * Runtime 1 ms Beats 70.00% of users with Java
     * Memory 44.61 MB Beats 63.43% of users with Java
     */
    public int[] sortArrayByParity(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            int currentP = nums[p];
            int currentQ = nums[q];
            if (currentP % 2 == 0) {
                p++;
                continue;
            }
            if (currentQ % 2 != 0) {
                q--;
                continue;
            }
            nums[p] = currentQ;
            nums[q] = currentP;
            p++;
            q--;
        }
        return nums;
    }
}
