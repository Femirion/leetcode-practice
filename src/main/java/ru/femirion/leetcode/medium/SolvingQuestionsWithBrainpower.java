package ru.femirion.leetcode.medium;

/**
 * 2140. Solving Questions With Brainpower
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
public class SolvingQuestionsWithBrainpower {

    /**
     * Runtime 6 ms Beats 67.21%
     * Memory 108.14 MB Beats 74.05%
     */
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];


        for (int i = questions.length - 1; 0 <= i; i--) {
            long skipQuestionValues = i + questions[i][1] + 1 < dp.length ? dp[i + questions[i][1] + 1] + questions[i][0] : questions[i][0];
            dp[i] = Math.max(dp[i + 1], skipQuestionValues);
        }

        return dp[0];
    }
}
