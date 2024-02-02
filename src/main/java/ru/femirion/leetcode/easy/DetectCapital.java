package ru.femirion.leetcode.easy;

/**
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/description/
 */
public class DetectCapital {

    /**
     * Runtime 1 ms Beats 92.08% of users with Java
     * Memory 41.66 MB Beats 58.58% of users with Java
     */
    public boolean detectCapitalUse(String word) {
        int countOfCapital = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isCapital(word.charAt(i))) {
                countOfCapital++;
            }
        }
        if (countOfCapital == 0 || countOfCapital == word.length()) {
            return true;
        }
        if (countOfCapital == 1 && isCapital(word.charAt(0))) {
            return true;
        }
        return false;
    }

    private boolean isCapital(char c) {
        return c > 92 && c < 116;
    }
}
