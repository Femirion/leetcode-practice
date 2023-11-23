package ru.femirion.leetcode.easy;

/**
 * 2148. Count Elements With Strictly Smaller and Greater Elements
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 */
public class CountElementsWithStrictlySmallerAndGreaterElements {

    public int countElements(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return 0;
        }
        int count = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && nums[i] != min) {
                count++;
            }
        }
        return count;
    }
}
