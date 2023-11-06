package ru.femirion.leetcode.easy;

/**
 * 1662. Check If Two String Arrays are Equivalent
 *
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 */
public class CheckIfTwoStringArraysAreEquivalent {

    /**
     * Runtime 3ms Beats 7.35% of users with Java
     * Memory 39.80MB Beats 96.87% of users with Java
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int m = 0;
        int n = 0;

        boolean result = true;
        while (i < word1.length || j < word2.length) {
            if (((i == word1.length && j != word2.length)) || ((i != word1.length && j == word2.length))) {
                return false;
            }
            char x = word1[i].charAt(m);
            char y = word2[j].charAt(n);
            if (x != y) {
                return false;
            }
            if (word1[i].length() - 1  == m) {
                m = 0;
                i++;
            } else {
                m++;
            }
            if (word2[j].length() - 1 == n) {
                n = 0;
                j++;
            } else {
                n++;
            }
        }
        return result;
    }

    /**
     * Runtime 1ms Beats 74.17% of users with Java
     * Memory 40.26MB Beats 59.67% of users with Java
     */
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String str : word1) {
            sb1.append(str);
        }

        StringBuilder sb2 = new StringBuilder();
        for (String str : word2) {
            sb2.append(str);
        }

        return sb2.toString().contentEquals(sb1);
    }

}
