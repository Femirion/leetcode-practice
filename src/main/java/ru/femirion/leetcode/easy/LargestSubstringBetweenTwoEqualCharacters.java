package ru.femirion.leetcode.easy;

/**
 * 1624. Largest Substring Between Two Equal Characters
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.10 MB Beats 86.39% of users with Java
     */
    public int maxLengthBetweenEqualCharacters1(String s) {
        int[] arr = new int[26];

        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (arr[cur] == 0) {
                arr[cur] = i + 1;
            } else {
                max = Math.max(max, i - arr[cur]);
            }
        }

        return max;
    }

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
                arr[cur][0] = i + 1;
            } else {
                arr[cur][1] = i + 1;
                int tmp = arr[cur][1] - arr[cur][0];
                if (max < tmp) {
                    max = tmp;
                }
            }
        }

        return max - 1;
    }
}
