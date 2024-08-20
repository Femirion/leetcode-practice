package ru.femirion.leetcode.medium;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 */
public class EditDistance {

    /**
     * Runtime 5 ms Beats 66.46%
     * Memory 44.68 MB Beats 86.88%
     */
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        int[][] dp = new int[word1Length + 1][word2Length + 1];

        for (int i = 1; i <= word1Length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2Length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i][j - 1];
                    int insert = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(delete, Math.min(insert, replace)) + 1;
                }

            }
        }

        return dp[word1Length][word2Length];
    }
}
