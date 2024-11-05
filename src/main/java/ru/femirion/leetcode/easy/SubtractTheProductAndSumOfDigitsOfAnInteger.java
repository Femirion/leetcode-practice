package ru.femirion.leetcode.easy;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.25 MB Beats 64.26%
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int num;

        while (n != 0) {
            num = n % 10;
            product = product * num;
            sum = sum + num;
            n = n / 10;
        }
        return product - sum;
    }
}
