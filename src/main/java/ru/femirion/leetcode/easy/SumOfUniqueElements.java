package ru.femirion.leetcode.easy;

/**
 * 1748. Sum of Unique Elements
 * https://leetcode.com/problems/sum-of-unique-elements/
 */
public class SumOfUniqueElements {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 40.25MB Beats 45.97%of users with Java
     */
    public int sumOfUniqueWithSet(int[] nums) {
        int[] numbers = new int[101];
        for (int i = 0; i < nums.length; i++) {
            numbers[nums[i]] = numbers[nums[i]] + 1;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
