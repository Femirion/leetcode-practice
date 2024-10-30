package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 3285. Find Indices of Stable Mountains
 * https://leetcode.com/problems/find-indices-of-stable-mountains/description/
 */
public class FindIndicesOfStableMountains {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 44.72 MB Beats 39.72%
     */
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (threshold < height[i - 1]) {
                result.add(i);
            }
        }

        return result;
    }
}
