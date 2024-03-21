package ru.femirion.leetcode.easy;

/**
 * 1720. Decode XORed Array
 * https://leetcode.com/problems/decode-xored-array/description/
 *
 * #BitManipulation
 */
public class DecodeXORedArray {

    /**
     * Runtime 2 ms Beats 91.82% of users with Java
     * Memory 45.57 MB Beats 65.93% of users with Java
     */
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];

        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }
        return result;
    }
}
