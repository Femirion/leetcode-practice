package ru.femirion.leetcode.easy;

/**
 * 1822. Sign of the Product of an Array
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */
public class SignOfTheProductOfAnArray {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 43.79MB Beats 8.12%of users with Java
     */
    public int arraySign(int[] nums) {
        boolean isPositive = true;
        for (int i : nums) {
            if (i < 0) {
                isPositive = !isPositive;
            } else if (i > 0) {
                isPositive = isPositive;
            } else {
                return 0;
            }
        }
        return isPositive ? 1 : -1;
    }
}
