package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1636. Sort Array by Increasing Frequency
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 */
public class SortArrayByIncreasingFrequency {

    /**
     * Runtime 12 ms Beats 11.74%
     * Memory 44.50 MB Beats 51.83%
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        nums = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                            int compareResult = map.get(a).compareTo(map.get(b));
                            if (compareResult == 0) {
                                return b - a;
                            } else {
                                return compareResult;
                            }
                        }
                )
                .mapToInt(i -> i)
                .toArray();
        return nums;
    }
}
