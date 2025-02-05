package ru.femirion.leetcode.medium;

import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {

    /**
     * Runtime 5 ms Beats 64.84%
     * Memory 41.48 MB Beats 98.54%
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        char[] chars = s.toCharArray();

        for (int i = s.length() - 1; 0 <= i; i--) {
            for (String word : wordDict) {
                int length =  word.length();

                if (s.length() < i + length) {
                    continue;
                }

                boolean isSame = equals(chars, word, i, i + length);
                if (isSame) {
                    dp[i] = dp[i] || dp[i + length];
                }
            }
        }

        return dp[0];
    }

    private boolean equals(char[] chars, String w, int start, int end) {
        int idx = 0;
        for (int i = start; i < end; i++) {
            if (w.charAt(idx) != chars[i]) {
                return false;
            }
            idx++;
        }
        return true;
    }


    /**
     * Runtime 8 ms Beats 45.03%
     * Memory 43.60 MB Beats 61.13%
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; 0 <= i; i--) {
            for (String word : wordDict) {
                int length =  word.length();

                if (s.length() < i + length) {
                    continue;
                }

                String sub = s.substring(i, i + length);
                boolean isSame = sub.equals(word);
                if (isSame) {
                    dp[i] = dp[i] || dp[i + length];
                }
            }
        }

        return dp[0];
    }
}
