package ru.femirion.leetcode.easy;

/**
 * 2114. Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */
public class MaximumNumberOfWordsFoundInSentences {

    /**
     * Runtime 4ms Beats 27.65% of users with Java
     * Memory 41.03MB Beats 90.63% of users with Java
     */
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        int current = 1;
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    current++;
                }
            }
            if (max < current) {
                max = current;
            }
            current = 1;
        }
        return max;
    }
}
