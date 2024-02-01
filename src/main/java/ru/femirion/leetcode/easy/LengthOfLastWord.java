package ru.femirion.leetcode.easy;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthOfLastWord {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.47 MB Beats 62.64% of users with Java
     */
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int q = s.length() - 1;
        boolean hasSymbol = false;
        while (q >= 0) {
            char current = s.charAt(q);
            if (current != ' ') {
                if (!hasSymbol) {
                    end = q;
                    hasSymbol = true;
                }
              q--;
            } else {
                if (!hasSymbol) {
                    q--;
                } else {
                  return end - q;
                }
            }
        }
        return end - q;
    }
}
