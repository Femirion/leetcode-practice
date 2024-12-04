package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {

    /**
     * Runtime 1 ms Beats 95.24%
     * Memory 44.78 MB Beats 64.15%
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 1) {
            return List.of(words[0]);
        }

        boolean[] dp = new boolean[words.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = true;
        }

        for (int i = groups.length - 2; 0 <= i; i--) {
            if (groups[i] == groups[i + 1]) {
                dp[i + 1] = false;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                result.add(words[i]);
            }
        }

        return result;
    }
}
