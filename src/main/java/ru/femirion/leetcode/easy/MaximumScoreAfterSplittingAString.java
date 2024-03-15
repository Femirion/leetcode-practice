package ru.femirion.leetcode.easy;

/**
 * 1422. Maximum Score After Splitting a String
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
 */
public class MaximumScoreAfterSplittingAString {

    /**
     * Runtime 1 ms Beats 98.10% of users with Java
     * Memory 41.02 MB Beats 94.82% of users with Java
     */
    public int maxScore(String s) {
        char[] chars = s.toCharArray();


        int maxLeftScore = chars[0] == '0' ? 1 : 0;
        int maxRightScore = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                maxRightScore++;
            }
        }

        int maxTotalScore = maxLeftScore + maxRightScore;

        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                maxLeftScore++;
            }
            if (chars[i] == '1') {
                maxRightScore--;
            }
            if (maxTotalScore < (maxLeftScore + maxRightScore)) {
                maxTotalScore = maxLeftScore + maxRightScore;
            }
        }
        return maxTotalScore;
    }
}
