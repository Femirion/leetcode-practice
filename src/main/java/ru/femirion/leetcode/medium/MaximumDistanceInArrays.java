package ru.femirion.leetcode.medium;

import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * https://leetcode.com/problems/maximum-distance-in-arrays/description/
 */
public class MaximumDistanceInArrays {

    /**
     * Runtime 6 ms Beats 94.09%
     * Memory 64.55 MB Beats 45.15%
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
}
