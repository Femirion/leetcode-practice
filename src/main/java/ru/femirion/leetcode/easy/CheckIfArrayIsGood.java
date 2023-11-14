package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2784. Check if Array is Good
 * https://leetcode.com/problems/check-if-array-is-good/
 */
public class CheckIfArrayIsGood {

    /**
     * Runtime ms Beats 28.87% of users with Java
     * Memory 43.30MB Beats 5.24% of users with Java
     */
    public boolean isGood(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer x = counts.get(current);
            if (x == null) {
                counts.put(current, 1);
            } else {
                counts.put(current, ++x);
            }
            if (max < current) {
                max = current;
            }
        }
        boolean result = true;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getKey() == max) {
                if (entry.getValue() != 2) {
                    result = false;
                }
                continue;
            }
            if (entry.getValue() != 1) {
                result = false;
            }
        }

        if (nums.length != max + 1) {
            return false;
        }

        return result;
    }
}
