package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1287. Element Appearing More Than 25% In Sorted Array
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/
 */
public class ElementAppearingMoreThan25InSortedArray {

    /**
     * Runtime 5 ms Beats 28.34% of users with Java
     * Memory 45.04 MB Beats 30.13% of users with Java
     */
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int limit = Math.round((float) arr.length / 4 + 0.5f);

        for (int i = 0; i < arr.length; i++) {
            int count = (map.getOrDefault(arr[i], 0) + 1);
            if (count >= limit) {
                return arr[i];
            }
            map.put(arr[i], count);
        }
        return 0;
    }
}
