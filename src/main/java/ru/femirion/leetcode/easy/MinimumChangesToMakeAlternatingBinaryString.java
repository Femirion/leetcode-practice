package ru.femirion.leetcode.easy;

/**
 * 1758. Minimum Changes To Make Alternating Binary String
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    /**
     * Runtime 2 ms Beats 93.91% of users with Java
     * Memory 42.49 MB Beats 32.15% of users with Java
     */
    public int minOperations(String s) {
        int minF = 0;
        int minS = 0;
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i % 2 == 0) {
                if (c == '1') {
                    minF++;
                } else {
                    minS++;
                }
            } else {
                if (c == '0') {
                    minF++;
                } else {
                    minS++;
                }
            }
            i++;
        }
        return Math.min(minF, minS);
    }
}
