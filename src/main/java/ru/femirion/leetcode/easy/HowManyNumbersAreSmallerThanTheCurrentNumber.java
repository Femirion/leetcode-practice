package ru.femirion.leetcode.easy;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * Runtime 7 ms Beats 74.09%
     * Memory 44.30 MB Beats 73.77%
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int curCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    curCount++;
                }
            }
            result[i] = curCount;
        }

        return result;
    }
}
