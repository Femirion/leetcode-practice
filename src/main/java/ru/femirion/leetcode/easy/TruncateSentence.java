package ru.femirion.leetcode.easy;

/**
 * 1816. Truncate Sentence
 * https://leetcode.com/problems/truncate-sentence/description/
 */
public class TruncateSentence {

    /**
     * Runtime 1 ms Beats 79.32%
     * Memory 41.62 MB Beats 66.53%
     */
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int wordCount = 0;
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                wordCount++;
            }
            if (wordCount == k) {
                break;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
