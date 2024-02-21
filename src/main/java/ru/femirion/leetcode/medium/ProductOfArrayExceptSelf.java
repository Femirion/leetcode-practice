package ru.femirion.leetcode.medium;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductOfArrayExceptSelf {

    /**
     * Runtime 3 ms Beats 20.23% of users with Java
     * Memory 53.12 MB Beats 71.42% of users with Java
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int product = 1;
        result[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            product = product * nums[i];
            result[i + 1] = product;
        }

        product = 1;
        for (int i = nums.length - 1; 0 < i; i--) {
            product = product * nums[i];
            result[i - 1] = product * result[i - 1];
        }

        return result;
    }
}
