package ru.femirion.leetcode.easy;

/**
 * 3442. Maximum Difference Between Even and Odd Frequency I
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 42.20 MB Beats 96.11%
     */
    public int maxDifference(String s) {
        byte[] chars = new byte[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        byte maxOdd = 0;
        byte minEven = 127;

        for (byte b : chars) {
            if (b == 0) {
                continue;
            }
            if (b % 2 == 0) {
                if (b < minEven) {
                    minEven = b;
                }
            } else if (maxOdd < b) {
                maxOdd = b;
            }
        }

        return maxOdd - minEven;
    }
}
