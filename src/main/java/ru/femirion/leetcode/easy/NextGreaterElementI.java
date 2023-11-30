package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {

    /**
     * Runtime 2ms Beats 99.23% of users with Java
     * Memory 44.11MB Beats 8.66% of users with Java
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        boolean needToSetMinusOne = true;
        for (int i = 0; i < nums2.length - 1; i++) {
            int current = nums2[i];
            needToSetMinusOne = true;
            for (int j = i + 1; j < nums2.length; j++) {
                if (current < nums2[j]) {
                    map.put(current, nums2[j]);
                    needToSetMinusOne = false;
                    break;
                }
            }
            if (needToSetMinusOne) {
                map.put(current, -1);
            }
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
           result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

}
