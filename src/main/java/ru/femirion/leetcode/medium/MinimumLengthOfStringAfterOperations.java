package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3223. Minimum Length of String After Operations
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
 */
public class MinimumLengthOfStringAfterOperations {

    /**
     * Runtime 87 ms Beats 29.80%
     * Memory 50.81 MB Beats 9.27%
     */
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();

        boolean hasDiff = false;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int result = 0;
        for (Integer value : map.values()) {
            if (2 < value) {
                if (value % 2 == 0) {
                    result = result + 2;
                } else {
                    result = result + 1;
                }
            } else {
                result = result + value;
            }
        }

        return result;
    }

    /**
     * Runtime 10 ms Beats 82.12%
     * Memory 46.10 MB Beats 75.50%
     */
    public int minimumLength2(String s) {
        int[] map = new int[26];

        boolean hasDiff = false;
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }


        int result = 0;
        for (int value : map) {
            if (2 < value) {
                if (value % 2 == 0) {
                    result = result + 2;
                } else {
                    result = result + 1;
                }
            } else {
                result = result + value;
            }
        }

        return result;
    }
}
