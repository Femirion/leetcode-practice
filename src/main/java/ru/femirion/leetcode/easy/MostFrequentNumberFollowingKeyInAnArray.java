package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2190. Most Frequent Number Following Key In an Array
 * https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
 */
public class MostFrequentNumberFollowingKeyInAnArray {

    /**
     * Runtime 2ms Beats 75.81% of users with Java
     * Memory 43.34MB Beats 27.44% of users with Java
     */
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0;
        int maxValue = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (key != nums[i]) {
                continue;
            }
            int count = counts.getOrDefault(nums[i + 1], 0);
            count++;
            counts.put(nums[i + 1], count);
            if (count > max) {
                max = count;
                maxValue = nums[i + 1];
            }
        }
        return maxValue;
    }

}
