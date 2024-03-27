package ru.femirion.leetcode.easy;

/**
 * 1624. Largest Substring Between Two Equal Characters
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * Runtime 1 ms Beats 88.34% of users with Java
     * Memory 41.22 MB Beats 60.63% of users with Java
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] arr = new int[26][2];

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (arr[cur][0] == 0) {
                arr[cur][0] = i;
            } else {
                arr[cur][1] = i;
                int tmp = arr[cur][1] - arr[cur][0];
                if (max < tmp) {
                    max = tmp;
                }
            }
        }

        return max == 0 ? - 1: max;
    }
}
