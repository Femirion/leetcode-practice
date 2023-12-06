package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2248. Intersection of Multiple Arrays
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 */
public class IntersectionOfMultipleArrays {

    /**
     * Runtime 2ms Beats 100.00%of users with Java
     * Memory 43.18MB Beats 98.59%of users with Java
     */
    public List<Integer> intersection(int[][] nums) {
        int[] counters = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int current = nums[i][j];
                counters[current] = counters[current] + 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }

}
