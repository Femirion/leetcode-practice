package ru.femirion.leetcode.medium;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    /**
     * Runtime 13 ms Beats 73.06% of users with Java
     * Memory 44.59 MB Beats 61.55% of users with Java
     */
    public int maxVowels(String s, int k) {
        int currentVowels = 0;
        char cur;
        for (int i = 0; i < k; i++) {
            cur = s.charAt(i);
            if (isVowel(cur)) {
                currentVowels++;
            }
        }

        int maxVowels = currentVowels;

        char prev;
        for (int i = k; i < s.length(); i++) {
            prev = s.charAt(i - k);
            if (isVowel(prev)) {
                currentVowels--;
            }
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if (currentVowels > maxVowels) {
                maxVowels = currentVowels;
            }
        }
        return maxVowels;
    }

    private boolean isVowel(char c) {
        // 'a', 'e', 'i', 'o', and 'u'
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}
