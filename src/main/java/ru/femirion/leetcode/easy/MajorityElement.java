package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {

    /**
     * Runtime 13 ms Beats 27.45% of users with Java
     * Memory 48.85 MB Beats 69.34% of users with Java
     */
    public int majorityElement(int[] nums) {
        int maxCountElement = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int currentCount = map.getOrDefault(current, 0);
            currentCount++;
            if (maxCount < currentCount) {
                maxCount = currentCount;
                maxCountElement = current;
            }
            map.put(current, currentCount);
            if (maxCount >= nums.length / 2) {
                return maxCountElement;
            }
        }
        return maxCountElement;
    }

}
