package ru.femirion.leetcode.easy;

/**
 * 1668. Maximum Repeating Substring
 * https://leetcode.com/problems/maximum-repeating-substring/description/
 */
public class MaximumRepeatingSubstring {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.65 MB Beats 56.57%
     */
    public int maxRepeating(String sequence, String word) {
        int count = 0;

        if (sequence.length() < word.length()) {
            return 0;
        }

        int seqIdx = sequence.length() - 1;

        int[] dp = new int[sequence.length() + word.length()];
        int max = 0;

        while (0 <= seqIdx) {
            if (contains(sequence, seqIdx, word)) {
                dp[seqIdx] = dp[seqIdx + word.length()] + 1;
                max = Math.max(dp[seqIdx], max);
            }
            seqIdx--;
        }

        return max;
    }

    private boolean contains(String seq, int seqIdx, String word) {
        if (seqIdx - word.length() + 1 < 0) {
            return false;
        }
        int wordIdx = word.length() - 1;
        for (int i = seqIdx; seqIdx - word.length() < i; i--) {
            if (word.charAt(wordIdx) != seq.charAt(i)) {
                return false;
            }
            wordIdx--;
        }

        return true;
    }
}
