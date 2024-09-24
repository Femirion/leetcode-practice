package ru.femirion.leetcode.medium;

/**
 * 2433. Find The Original Array of Prefix Xor
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
 */
public class FindTheOriginalArrayOfPrefixXor {

    /**
     * Runtime 2 ms Beats 90.16%
     * Memory 56.26 MB Beats 98.96%
     */
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i - 1] ^ pref[i];
        }

        return result;
    }
}
