package ru.femirion.leetcode.easy;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {

    /**
     * Runtime 3 ms Beats 75.51%
     * Memory 42.71 MB Beats 68.04%
     */
    public boolean isPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;

        while (p <= q) {
            char cP = Character.toLowerCase(s.charAt(p));
            char cQ = Character.toLowerCase(s.charAt(q));

            if (!Character.isAlphabetic(cP) && !Character.isDigit(cP)) {
                p++;
                continue;
            }
            if (!Character.isAlphabetic(cQ) && !Character.isDigit(cQ)) {
                q--;
                continue;
            }

            if (cP != cQ) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

}
