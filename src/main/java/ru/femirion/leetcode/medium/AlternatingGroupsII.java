package ru.femirion.leetcode.medium;

/**
 * 3208. Alternating Groups II
 * https://leetcode.com/problems/alternating-groups-ii/description/
 */
public class AlternatingGroupsII {

    /**
     * Runtime 3 ms Beats 86.87%
     * Memory 63.17 MB Beats 50.00%
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0;
        int end = 1;

        int result = 0;
        int prevColor = colors[0];
        for (int i = 1; i < colors.length + k - 1; i++) {
            int idx = i < colors.length ? i : i - colors.length;
            int curColor = colors[idx];
            if (curColor == prevColor) {
                start = end;
                end++;
            } else {
                if (end - start < k) {
                    end++;
                }
                if (end - start == k) {
                    result++;
                    end++;
                    start++;
                }

            }
            prevColor = curColor;
        }

        return result;
    }
}
